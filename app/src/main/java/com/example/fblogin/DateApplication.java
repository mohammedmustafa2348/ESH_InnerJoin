package com.example.fblogin;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class DateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
/*      try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.fblogin",  // replace with your unique package name
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
*/
    }
}