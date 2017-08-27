package jazevangelio.newvawepp.ui.map.police;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.List;

import io.realm.Realm;
import jazevangelio.newvawepp.app.App;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.Company;
import jazevangelio.newvawepp.model.data.NearCompany;
import jazevangelio.newvawepp.util.DistanceUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class MapPresenter extends MvpNullObjectBasePresenter<MapView> {
    private Realm realm;

    void onStart() {
        realm = Realm.getDefaultInstance();
        getCompany();
    }

    public void getCompany() {
        getView().startLoading("Getting data...");
        App.getInstance().getApiInterface().getCompanies(Endpoints.ALL_COMPANY,"P").enqueue(new Callback<List<Company>>() {
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
                            Log.e(TAG, "onError: Unable to save Company", error);
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
        getView().startLoading("calculating distance...");
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
}
