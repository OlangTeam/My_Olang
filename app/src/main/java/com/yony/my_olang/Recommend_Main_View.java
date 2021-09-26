package com.yony.my_olang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Recommend_Main_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reccommend_main_view);

        ImageView btnprofile = (ImageView) findViewById(R.id.profile_view);
        TextView btnintro = (TextView) findViewById(R.id.intro_view);
        TextView btnmore = (TextView) findViewById(R.id.more_categ_btn);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.profile_view:
                        Intent intent = new Intent(getApplicationContext(), Reccommend_View.class);
                        startActivity(intent);
                        break;

                    case R.id.intro_view:
                        intent = new Intent(getApplicationContext(), Reccommend_View.class);
                        startActivity(intent);
                        break;
                    case R.id.more_categ_btn:
                        intent = new Intent(getApplicationContext(), Recommend_Caegory_View.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        btnprofile.setOnClickListener(listener);
        btnintro.setOnClickListener(listener);
        btnmore.setOnClickListener(listener);
    }
}