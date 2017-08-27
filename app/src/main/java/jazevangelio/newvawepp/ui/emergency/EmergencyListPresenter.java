package jazevangelio.newvawepp.ui.emergency;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import io.realm.Realm;
import jazevangelio.newvawepp.app.App;
import jazevangelio.newvawepp.app.Constants;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.model.response.ResultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@SuppressWarnings("ConstantConditions")
public class EmergencyListPresenter extends MvpBasePresenter<EmergencyListView> {


    private Realm realm;
    private User user;

    public void onStart() {
        realm = Realm.getDefaultInstance();
        user = App.getUser();
    }

    public void load(String userId) {
        App.getInstance().getApiInterface().getEmergency(Endpoints.ALL_EMERGENCY,userId)
                .enqueue(new Callback<List<Emergency>>() {
                    @Override
                    public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {
                        if (isViewAttached()) {
                            getView().stopRefresh();
                        }
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
                                    if (isViewAttached())
                                        getView().showAlert(error.getLocalizedMessage());
                                }
                            });
                        } else {
                            if (isViewAttached())
                                getView().showAlert(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Emergency>> call, Throwable t) {
                        t.printStackTrace();
                        if (isViewAttached()) {
                            getView().stopRefresh();
                            getView().showAlert(t.getLocalizedMessage());
                        }
                    }
                });
    }


    public void updateContact(String contactId, String name,String contact) {
        if (name.equals("") || contact.equals("")) {
            getView().showAlert("Fill-up all fields");
        } else {
            getView().startLoading();
            App.getInstance().getApiInterface().updateEmergency(Endpoints.EDIT_EMERGENCY,contactId, name,contact)
                    .enqueue(new Callback<List<Emergency>>() {
                        @Override
                        public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {
                            getView().stopLoading();
                            if (response.isSuccessful()) {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.copyToRealmOrUpdate(response.body());

                                    }
                                });
                            } else {
                                getView().showAlert("Oops something went wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Emergency>> call, Throwable t) {

                            getView().stopLoading();
                            getView().showAlert("Error Connecting to Server");
                        }
                    });
        }
    }


    public void addContact(String userId, final String name, final String contact) {
        if (name.equals("") || contact.equals("")) {
            getView().showAlert("Fill-up all fields");
        } else {
            getView().startLoading();
            App.getInstance().getApiInterface().addEmergency(Endpoints.ADD_EMERGENCY,userId, name,contact)
                    .enqueue(new Callback<List<Emergency>>() {
                        @Override
                        public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {
                            getView().stopLoading();
                            if (response.isSuccessful()) {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.copyToRealmOrUpdate(response.body());
                                        getView().successAdd(name,contact);

                                    }
                                });
                            } else {
                                getView().showAlert("Oops something went wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Emergency>> call, Throwable t) {

                            getView().stopLoading();
                            getView().showAlert("Error Connecting to Server");
                        }
                    });
        }
    }


    public void deleteContact(String userId, String contactId) {

            getView().startLoading();
            App.getInstance().getApiInterface().deleteEmergency(Endpoints.DELETE_EMERGENCY,userId, contactId)
                    .enqueue(new Callback<List<Emergency>>() {
                        @Override
                        public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {
                            getView().stopLoading();
                            if (response.isSuccessful()) {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        getView().onRefreshDelete();
                                    }
                                });
                            } else {
                                getView().showAlert("Oops something went wrong");
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Emergency>> call, Throwable t) {

                            getView().stopLoading();
                            getView().showAlert("Error Connecting to Server");
                        }
                    });

    }



    public void onStop() {
        realm.close();
    }

}
