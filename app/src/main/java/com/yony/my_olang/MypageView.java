package com.yony.my_olang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MypageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_view);

        TextView text = (TextView) findViewById(R.id.myProfile);
        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfileChangeView.class);
                startActivity(intent);
            }
        });

        Button btn = (Button) findViewById(R.id.typeSet);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecommendPreferenceView.class);
                startActivity(intent);
            }
        });

        TextView text1 = (TextView) findViewById(R.id.chMyInfo);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyInfoView.class);
            }
        });

        TextView text2 = (TextView) findViewById(R.id.chMyPW);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PasswardChangeView.class);
            }
        });

        TextView text3 = (TextView) findViewById(R.id.idCard);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IdCardView.class);
            }
        });

        TextView text4 = (TextView) findViewById(R.id.appSet);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlramSetView.class);
            }
        });

        TextView text5 = (TextView) findViewById(R.id.lockSet);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LockSetView.class);
            }
        });

        TextView text6 = (TextView) findViewById(R.id.signOut);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignOutView.class);
            }
        });

        TextView text7 = (TextView) findViewById(R.id.logout);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogoutConfirmView.class);
            }
        });

    }

}