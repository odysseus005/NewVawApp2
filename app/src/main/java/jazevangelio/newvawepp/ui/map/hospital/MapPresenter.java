package jazevangelio.newvawepp.ui.map.hospital;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.List;

import io.realm.Realm;
import jazevangelio.newvawepp.app.App;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.Company;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.NearCompany;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.util.DistanceUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class MapPresenter extends MvpNullObjectBasePresenter<MapView> {
    private Realm realm;
    private User user;

    void onStart() {
        realm = Realm.getDefaultInstance();
        user = realm.where(User.class).findFirst();
        getCompany();
        load(user.getUserId()+"");

    }



    public void getCompany() {
        getView().startLoading();
        App.getInstance().getApiInterface().getCompanies(Endpoints.ALL_COMPANY,"H").enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, final Response<List<Company>> response) {
                getView().stopLoading();
                if (response.isSuccessful() || response.body().isEmpty()) {
                    final Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.delete(Company.class);
                            realm.copyToRealmOrUpdate(response.body());
                        }
                    }, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            realm.close();
                            getView().updateMap();
                        }
                    }, new Realm.Transaction.OnError() {
                        @Override
                        public void onError(Throwable error) {
                            realm.close();
                            Log.e(TAG, "onError: Unable to save Restaurants", error);
                        }
                    });
                } else {
                    getView().showAlert(response.message() != null ? response.message()
                            : "Unknown Error");
                }
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                Log.e(TAG, "onFailure: Error calling login api", t);
                getView().stopLoading();
                getView().showAlert("Error Connecting to Server");
            }
        });
    }


    public void onStop() {
        realm.close();
    }


    void getNearest(double latitude, double longitude) {
        final Realm realm = Realm.getDefaultInstance();
        getView().startLoading();
        List<Company> companys = realm.where(Company.class).findAll();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(NearCompany.class);
            }
        });
        for (Company company : companys) {
            Double distance = DistanceUtil.distanceBetween(latitude, longitude,company.getCompanyLat(), company.getCompanyLng());
            final NearCompany nearest = new NearCompany();
            nearest.setCompanyId(company.getCompanyId());
            nearest.setCompanyName(company.getCompanyName());
            nearest.setCompanyContact(company.getCompanyContact());
            nearest.setCompanyLat(company.getCompanyLat());
            nearest.setCompanyLng(company.getCompanyLng());
            nearest.setCompanyAddress(company.getCompanyAddress());
            nearest.setDistance(distance);
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(nearest);
                }
            });
        }
        getView().stopLoading();
        realm.close();
    }

    public void load(String userId) {
        App.getInstance().getApiInterface().getEmergency(Endpoints.ALL_EMERGENCY,userId)
                .enqueue(new Callback<List<Emergency>>() {
                    @Override
                    public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {
                        getView().stopLoading();
                        if (response.isSuccessful()) {
                            final Realm realm = Realm.getDefaultInstance();
                            realm.executeTransactionAsync(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.delete(Emergency.class);
                                    realm.copyToRealmOrUpdate(response.body());
                                }
                            }, new Realm.Transaction.OnSuccess() {
                                @Override
                                public void onSuccess() {
                                    realm.close();
                                }
                            }, new Realm.Transaction.OnError() {
                                @Override
                                public void onError(Throwable error) {
                                    realm.close();
                                    error.printStackTrace();

                                        getView().showAlert(error.getLocalizedMessage());
                                }
                            });
                        } else {

                                getView().showAlert(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Emergency>> call, Throwable t) {
                        t.printStackTrace();

                        getView().stopLoading();
                            getView().showAlert(t.getLocalizedMessage());

                    }
                });
    }


}
