package com.yony.my_olang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class IdPw_Find extends AppCompatActivity {

    private static final String TAG = "IdPw_Find";

    private EditText et_name; //이름
    private EditText et_id; //아이디
    private EditText et_pass; //비밀번호
    private EditText et_hp; //핸드폰 번호
    private Button btn_join,btn_login, btn_id_found, btn_pw_found; //회원가입,로그인

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        et_name = (EditText) findViewById(R.id.et_id_name);
        et_id = (EditText) findViewById(R.id.et_id_hp);
        et_pass = (EditText) findViewById(R.id.et_pw_email);
        btn_id_found = (Button) findViewById(R.id.bt_idfound);
        btn_pw_found = (Button) findViewById(R.id.bt_pw_email);
        btn_join = (Button) findViewById(R.id.btn_join);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_id_found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPw_Find.this, Id_Found_Result_View.class);
                startActivity(intent);
            }
        });

        btn_pw_found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPw_Find.this, PW_Found_Result_View.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPw_Find.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPw_Find.this, JoinView.class);
                startActivity(intent);
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();
    }

}