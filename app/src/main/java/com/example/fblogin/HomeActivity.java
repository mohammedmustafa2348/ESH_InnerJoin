package com.example.fblogin;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entity.Credentials;
import com.example.entity.User;
import com.example.utils.PrefUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private User user;
    private ImageView profileImage;
    private TextView txtProfileInfo;
    //ProfilePictureView profilePictureView;
    Bitmap bitmap;
    ImageButton btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profileImage = (ImageView) findViewById(R.id.profileImage);
        txtProfileInfo = (TextView)findViewById(R.id.txtProfileInfo);
        Map<String, Integer> prefmap = PreferenceActivity.getUserPreferenceMap();
        //txtProfileInfo.setText(user.name+", "+user.age);
        //txtProfileInfo.setText(user.name);
        // fetching facebook's profile picture
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                URL imageURL = null;
                try {
                    imageURL = new URL("https://graph.facebook.com/" + getIntent().getStringExtra("facebookId") + "/picture?type=large");
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


        final ImageButton btnReject = (ImageButton)findViewById(R.id.btnReject);
        btnAccept = (ImageButton)findViewById(R.id.btnAccept);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                btnReject.setVisibility(View.INVISIBLE);
                btnAccept.setVisibility(View.INVISIBLE);
                //HTTP code here
                //Starting a new Intent
            }
        });


    }
}

