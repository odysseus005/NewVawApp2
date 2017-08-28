package jazevangelio.newvawepp.ui.login;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.List;

import io.realm.Realm;
import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.app.App;
import jazevangelio.newvawepp.app.Constants;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.model.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter extends MvpNullObjectBasePresenter<LoginView> {
    private int login_counter = 0;
    private static final String TAG = LoginPresenter.class.getSimpleName();

    public void login(final String email, final String password) {
        if (email.isEmpty() || email.equals("")) {
            getView().showAlert("Please enter email");
        } else if (password.isEmpty() || password.equals("")) {
            getView().showAlert("Please enter Password");
        } else {
            getView().startLoading();
            App.getInstance().getApiInterface().login(Endpoints.LOGIN,email, password)
                    .enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call,
                                               final Response<LoginResponse> response) {
                            getView().stopLoading();
                            if (response.isSuccessful()) {
                                try {
                                    switch (response.body().getResult()) {
                                        case Constants.SUCCESS:
                                            final Realm realm = Realm.getDefaultInstance();
                                            realm.executeTransactionAsync(new Realm.Transaction() {
                                                @Override
                                                public void execute(Realm realm) {
                                                    User user = response.body().getUser();
                                                    realm.copyToRealmOrUpdate(user);
                                                    getView().onLoad(user);
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
                                                    Log.e(TAG, "onError: Unable to save USER", error);
                                                    getView().showAlert("Error Saving API Response");
                                                }
                                            });
                                            break;
                                        case Constants.NOT_EXIST:
                                            getView().showAlert("Email does not exist");
                                        case Constants.WRONG_PASSWORD:
                                            getView().showAlert("Wrong Password or Email");
                                            break;
                                        case "failed":
                                            getView().showAlert("Can't Connect to the Server!");

                                            break;
                                        default:
                                            getView().showAlert(String.valueOf(R.string.cantConnect));
                                            break;

                                    }
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                    getView().showAlert("Oops");
                                }
                            } else {
                                getView().showAlert(response.message() != null ? response.message()
                                        : "Unknown Error");
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e(TAG, "onFailure: Error calling login api", t);
                            getView().stopLoading();
                            getView().showAlert("Error Connecting to Server");
                        }
                    });
        }
    }


    public void load(String userId) {
        App.getInstance().getApiInterface().getEmergency(Endpoints.ALL_EMERGENCY,userId)
                .enqueue(new Callback<List<Emergency>>() {
                    @Override
                    public void onResponse(Call<List<Emergency>> call, final Response<List<Emergency>> response) {

                        if (response.isSuccessful()) {
                            final Realm realm = Realm.getDefaultInstance();
                            realm.executeTransactionAsync(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.delete(Emergency.class);
                                    realm.copyToRealmOrUpdate(response.body());
                                    getView().onLoginSuccess();
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

                            getView().showAlert(t.getLocalizedMessage());

                    }
                });
    }

}
