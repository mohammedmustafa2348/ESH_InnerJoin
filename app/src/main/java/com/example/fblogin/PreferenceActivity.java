package com.example.fblogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.entity.UserPreference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceActivity extends AppCompatActivity {

    static Map<String, Integer> userPreferenceMap;
    List<ImageButton> bubbleButtonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), PreferenceActivity.class);
                nextScreen.putExtra("userInfo", getIntent().getExtras());
                startActivity(nextScreen);
            }
        });

        //final ImageButton btnBubble = (ImageButton)findViewById(R.id.btnProgramming);
        addBubbleListeners();
    }



    private void addBubbleListeners(){
        StringBuilder sb = new StringBuilder();
        final ImageButton btnVideoGames = (ImageButton)findViewById(R.id.btnVideoGames);
        final ImageButton btnProgramming = (ImageButton)findViewById(R.id.btnProgramming);
        final ImageButton btnSinging = (ImageButton)findViewById(R.id.btnSinging);
        final ImageButton btnDancing = (ImageButton)findViewById(R.id.btnDancing);
        final ImageButton btnLiterature = (ImageButton)findViewById(R.id.btnLitterature);
        final ImageButton btnWriting = (ImageButton)findViewById(R.id.btnWriting);
        final ImageButton btnDiy = (ImageButton)findViewById(R.id.btnDiy);
        final ImageButton btnExercising = (ImageButton)findViewById(R.id.btnExercising);
        final ImageButton btnSports = (ImageButton)findViewById(R.id.btnSports);
        final ImageButton btnCamping = (ImageButton)findViewById(R.id.btnCamping);
        final ImageButton btnPhotography = (ImageButton)findViewById(R.id.btnPhotography);
        final ImageButton btnAnimals = (ImageButton)findViewById(R.id.btnAnimals);
        final ImageButton btnMovies = (ImageButton)findViewById(R.id.btnMovies);
        final ImageButton btnPottery = (ImageButton)findViewById(R.id.btnPottery);
        final ImageButton btnBoardGames = (ImageButton)findViewById(R.id.btnBoardGames);
        final ImageButton btnYoga = (ImageButton)findViewById(R.id.btnYoga);
        final ImageButton btnHunting = (ImageButton)findViewById(R.id.btnHunting);
        final ImageButton btnFishing = (ImageButton)findViewById(R.id.btnFishing);
        final ImageButton btnESH = (ImageButton)findViewById(R.id.btnESH);

        btnProgramming.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(userPreferenceMap.containsKey("Programming")){
                    if(userPreferenceMap.get("Programming") == 1){
                        btnProgramming.setImageResource(R.drawable.programming);
                        userPreferenceMap.put("Programming", 0);
                    }
                    else{
                        btnProgramming.setImageResource(R.drawable.programming_green);
                        userPreferenceMap.put("Programming", 1);
                    }
                }
                else{
                    btnProgramming.setImageResource(R.drawable.programming_green);
                    userPreferenceMap.put("Programming", 1);
                }
            }
        });

        btnVideoGames.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(userPreferenceMap.containsKey("VideoGames")){
                    if(userPreferenceMap.get("VideoGames") == 1){
                        btnVideoGames.setImageResource(R.drawable.videogames);
                        userPreferenceMap.put("VideoGames", 0);
                    }
                    else{
                        btnVideoGames.setImageResource(R.drawable.videogames_green);
                        userPreferenceMap.put("VideoGames", 1);
                    }
                }
                else{
                    btnVideoGames.setImageResource(R.drawable.videogames_green);
                    userPreferenceMap.put("VideoGames", 1);
                }
            }
        });

        btnSinging.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(userPreferenceMap.containsKey("Singing")){
                    if(userPreferenceMap.get("Singing") == 1){
                        btnSinging.setImageResource(R.drawable.singing);
                        userPreferenceMap.put("Singing", 0);
                    }
                    else{
                        btnSinging.setImageResource(R.drawable.singing);
                        userPreferenceMap.put("Singing", 1);
                    }
                }
                else{
                    btnSinging.setImageResource(R.drawable.singing_green);
                    userPreferenceMap.put("Singing", 1);
                }
            }
        });
    }


    public static  Map<String, Integer> getUserPreferenceMap() {
        if (userPreferenceMap == null){
            userPreferenceMap = new HashMap<String, Integer>();
        }
        return userPreferenceMap;
    }

    public void setUserPreferenceMap(Map<String, Integer> userPreferenceMap) {
        this.userPreferenceMap = userPreferenceMap;
    }

}
