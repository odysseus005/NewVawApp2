package jazevangelio.newvawepp.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import io.realm.Realm;
import jazevangelio.newvawepp.MainActivity;
import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.databinding.ActivityLoginBinding;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.ui.register.RegisterActivity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends MvpViewStateActivity<LoginView, LoginPresenter>
        implements LoginView, TextWatcher {


    // UI references.
    private ActivityLoginBinding binding;
    private ProgressDialog progressDialog;
    private Realm realm;
    User user;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        // Set up the login form.
        setRetainInstance(true);
        realm = Realm.getDefaultInstance();
        //
         user = realm.where(User.class).findFirst();
        if (user != null) {
            onLoginSuccess();
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setView(getMvpView());
        binding.etEmail.addTextChangedListener(this);
        binding.etPassword.addTextChangedListener(this);

        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                nextActivity(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();


        LoginButton loginButton = (LoginButton)findViewById(R.id.login_fb);
        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                nextActivity(profile);
                Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
                Log.d("TAG",""+e);
            }
        };
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);

    }
    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);

    }

    private void nextActivity(Profile profile){
        if(profile != null){
            Intent main = new Intent(LoginActivity.this, MainActivity.class);
            main.putExtra("name", profile.getFirstName());
            main.putExtra("surname", profile.getLastName());
            main.putExtra("imageUrl", profile.getProfilePictureUri(200,200).toString());
            startActivity(main);
        }
    }

    @Override
    protected  void onResume()
    {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        nextActivity(profile);
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Facebook login
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }
    /***
     * Start of LoginView
     ***/

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }

    /***
     * Start of MvpViewStateActivity
     ***/

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @NonNull
    @Override
    public ViewState<LoginView> createViewState() {
        setRetainInstance(true);
        return new LoginViewState();
    }

    /***
     * End of MvpViewStateActivity
     ***/

    @Override
    public void onNewViewStateInstance() {
        saveValues();
    }

    @Override
    public void onLoginButtonClicked() {
        presenter.login(
                binding.etEmail.getText().toString(),
                binding.etPassword.getText().toString()
        );
    }

    @Override
    public void onRegisterButtonClicked() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setEditTextValue(String username, String password) {
        binding.etEmail.setText(username);
        binding.etPassword.setText(password);
    }

    @Override
    public void startLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        if (progressDialog != null) progressDialog.dismiss();
    }


    @Override
    public void onLoginSuccess() {


            startActivity(new Intent(this, MainActivity.class));
            finish();


    }

    @Override
    public void onLoad(User user) {
        presenter.load(user.getUserId()+"");
    }





    @Override
    public void onForgotPasswordButtonClicked() {
      //  startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        saveValues();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void saveValues() {
        LoginViewState loginViewState = (LoginViewState) getViewState();
        loginViewState.setUsername(binding.etEmail.getText().toString());
        loginViewState.setPassword(binding.etPassword.getText().toString());
    }
}

