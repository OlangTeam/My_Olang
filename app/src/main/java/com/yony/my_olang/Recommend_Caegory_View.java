package com.yony.my_olang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recommend_Caegory_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reccommend_caegory_view);

        Button btnAI = (Button) findViewById(R.id.AIRec_btn);
        Button btnRandom = (Button) findViewById(R.id.RandomRec_btn);
        Button btnNear = (Button) findViewById(R.id.NearRec_btn);
        Button btnSame = (Button) findViewById(R.id.SameRec_btn);
        Button btnHobby = (Button) findViewById(R.id.HobbyRec_btn);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.AIRec_btn:
                        Intent intent = new Intent(getApplicationContext(),AI_Reccomend_View.class);
                        startActivity(intent);
                        break;
                    case R.id.RandomRec_btn:
                         intent = new Intent(getApplicationContext(),Random_Reccomend_View.class);
                        startActivity(intent);
                        break;
                    case R.id.NearRec_btn:
                        intent = new Intent(getApplicationContext(),Near_Reccomend_View.class);
                        startActivity(intent);
                        break;
                    case R.id.SameRec_btn:
                        intent = new Intent(getApplicationContext(),Same_Reccomend_View.class);
                        startActivity(intent);
                        break;
                    case R.id.HobbyRec_btn:
                        intent = new Intent(getApplicationContext(),Hobby_Reccomend_View.class);
                        startActivity(intent);
                        break;

                }
            }
        };
        btnAI.setOnClickListener(listener);
        btnRandom.setOnClickListener(listener);
        btnNear.setOnClickListener(listener);
        btnSame.setOnClickListener(listener);
        btnHobby.setOnClickListener(listener);

    }
}