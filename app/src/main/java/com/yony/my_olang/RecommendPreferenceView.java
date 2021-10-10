package com.yony.my_olang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecommendPreferenceView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_preference_view);

        Button btn1 = (Button) findViewById(R.id.confirm);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConfirmView.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.cancel);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CancelView.class);
                startActivity(intent);
            }
        });
    }
}