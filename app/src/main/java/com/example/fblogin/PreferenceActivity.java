package com.example.fblogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.entity.UserPreference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceActivity extends AppCompatActivity {

    Map<String, Integer> userPreferenceMap;
    List<ImageButton> bubbleButtonList;
    final String[]={}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        final ImageButton btnBubble = (ImageButton)findViewById(R.id.btnProgramming);

        //Listening to button event
        btnBubble.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                btnBubble.setImageResource(R.drawable.programming_green);
/*
                Intent nextScreen = new Intent(getApplicationContext(), OnBoardActivity2.class);
                startActivity(nextScreen);
*/
            }
        });
    }



    private void addBubbleListener(){
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

        btnBubble.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(!userPreferenceMap.containsKey("Programming")){
                    btnBubble.setImageResource(R.drawable.programming_green);
                    userPreferenceMap.put("Programming", 1);
                }
                else{
                    btnBubble.setImageResource(R.drawable.programming);
                    userPreferenceMap.put("Programming", 0);
                }()

            }
        });
    }


    public Map<String, Integer> getUserPreferenceMap() {
        if (userPreferenceMap == null){
            userPreferenceMap = new HashMap<String, Integer>();
        }
        return userPreferenceMap;
    }

    public void setUserPreferenceMap(Map<String, Integer> userPreferenceMap) {
        this.userPreferenceMap = userPreferenceMap;
    }

}
