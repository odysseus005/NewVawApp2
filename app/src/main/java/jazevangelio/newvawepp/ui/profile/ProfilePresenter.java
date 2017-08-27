package jazevangelio.newvawepp.ui.profile;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.app.App;
import jazevangelio.newvawepp.app.Constants;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.model.response.BasicResponse;
import jazevangelio.newvawepp.model.response.ResultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfilePresenter extends MvpNullObjectBasePresenter<ProfileView> {
    private static final String TAG = ProfilePresenter.class.getSimpleName();

    void changePassword(String currPass, String newPass, String confirmNewPass) {
        final User user = App.getUser();
        if (currPass.equals(user.getPassword())) {

             if (newPass.equals(confirmNewPass)) {
                getView().showProgress();
                App.getInstance().getApiInterface().changePassword(Endpoints.UPDATEPASS,user.getUserId() + "", newPass).enqueue(new Callback<ResultResponse>() {
                    @Override
                    public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                        getView().stopProgress();
                        if (response.isSuccessful()) {
                            if (response.body().getResult().equals(Constants.SUCCESS)) {
                                getView().onPasswordChanged();
                            } else {
                                getView().showAlert(String.valueOf(R.string.cantConnect));
                            }
                        } else {
                            getView().showAlert(response.message() != null ? response.message()
                                    : "Unknown Error");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultResponse> call, Throwable t) {
                        getView().stopProgress();
                        Log.e(TAG, "onFailure: Error calling login api", t);
                        getView().stopProgress();
                        getView().showAlert("Error Connecting to Server");
                    }
                });
            } else {
                getView().showAlert("New Password Mismatch");
            }
        } else {
            getView().showAlert("Wrong Current Password!");
        }
    }
}
