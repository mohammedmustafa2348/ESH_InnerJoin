package com.example.fblogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entity.User;
import com.example.utils.PrefUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeActivity extends AppCompatActivity {

    private User user;
    private ImageView profileImage;
    private TextView txtProfileInfo;
    //ProfilePictureView profilePictureView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        user = PrefUtils.getCurrentUser(HomeActivity.this);
        profileImage = (ImageView) findViewById(R.id.profileImage);
        txtProfileInfo = (TextView)findViewById(R.id.txtProfileInfo);
        //txtProfileInfo.setText(user.name+", "+user.age);
        //txtProfileInfo.setText(user.name);

        // fetching facebook's profile picture
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                URL imageURL = null;
                try {
                    imageURL = new URL("https://graph.facebook.com/" + user.facebookID + "/picture?type=large");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                profileImage.setImageBitmap(bitmap);
            }
        }.execute();

/*
        btnLogout = (TextView) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefUtils.clearCurrentUser(LogoutActivity.this);
                // We can logout from facebook by calling following method
                LoginManager.getInstance().logOut();
                Intent i = new Intent(LogoutActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
*/
    }
}

