package com.example.fblogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnBoardActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board2);

        Button btnNext = (Button) findViewById(R.id.btnNext);
        //Listening to button event
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), OnBoardActivity3.class);
                startActivity(nextScreen);
            }
        });
        Button btnSkip = (Button) findViewById(R.id.btnSkip);
        //Listening to button event
        btnSkip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(nextScreen);
            }
        });

    }
}
