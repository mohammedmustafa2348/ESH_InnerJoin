package com.example.fblogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.api.UserDao;
import com.example.entity.Credentials;
import com.example.entity.User;
import com.example.utils.PrefUtils;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONObject;

public class LoginActivity extends Activity {
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private TextView btnLogin;
    private Button btnregister;
    private ProgressDialog progressDialog;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(PrefUtils.getCurrentUser(LoginActivity.this) != null){
            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
            homeIntent.putExtra("userName", PrefUtils.getCurrentUser(LoginActivity.this).getName());
            homeIntent.putExtra("age", 30);
            homeIntent.putExtra("location", PrefUtils.getCurrentUser(LoginActivity.this).getLocation());
            homeIntent.putExtra("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cum praesertim illa perdiscere ludus esset. Duo Reges: constructio interrete. Re mihi non aeque satisfacit, et quidem locis pluribus. Istic sum, inquit. Claudii libidini, qui tum erat summo ne imperio, dederetur. Satisne ergo pudori consulat, si quis sine teste libidini pareat?");
            homeIntent.putExtra("interests", "Programming Singing Music");
            homeIntent.putExtra("facebookId", PrefUtils.getCurrentUser(LoginActivity.this).getFacebookID());
            startActivity(homeIntent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        callbackManager=CallbackManager.Factory.create();
        loginButton= (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile", "email","user_friends");
        btnLogin= (TextView) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                loginButton.performClick();
                loginButton.setPressed(true);
                loginButton.invalidate();
                loginButton.registerCallback(callbackManager, mCallBack);
                loginButton.setPressed(false);
                loginButton.invalidate();
                loginButton.performClick();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            progressDialog.dismiss();
            // App code
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            Log.e("response: ", response + "");
                            try {
                                user = new User();
                                user.setFacebookID(object.getString("id").toString());
                                user.getUserCredentials().setEmailId(object.getString("email").toString());
                                user.setName(object.getString("name").toString());
                                user.setGender(object.getString("gender").toString());
                                PrefUtils.setCurrentUser(user,LoginActivity.this);
                                UserDao userDao = new UserDao();
                                if(userDao.storeUser(user)){
                                    //stored successfully
                                }
                                /**need to call function to store user data into db*/
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            Toast.makeText(LoginActivity.this, "welcome "+user.getName(), Toast.LENGTH_LONG).show();
                            Intent prefIntent=new Intent(LoginActivity.this, PreferenceActivity.class);
                            prefIntent.putExtra("userName", PrefUtils.getCurrentUser(LoginActivity.this).getName());
                            prefIntent.putExtra("age", 30);
                            prefIntent.putExtra("location", PrefUtils.getCurrentUser(LoginActivity.this).getLocation());
                            prefIntent.putExtra("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cum praesertim illa perdiscere ludus esset. Duo Reges: constructio interrete. Re mihi non aeque satisfacit, et quidem locis pluribus. Istic sum, inquit. Claudii libidini, qui tum erat summo ne imperio, dederetur. Satisne ergo pudori consulat, si quis sine teste libidini pareat?");
                            prefIntent.putExtra("interests", "Programming Singing Music");
                            startActivity(prefIntent);
                            finish();
                        }

                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender,birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel() {
            progressDialog.dismiss();
        }

        @Override
        public void onError(FacebookException e) {
            progressDialog.dismiss();
        }

        public void registerUser(){

        }
    };

}