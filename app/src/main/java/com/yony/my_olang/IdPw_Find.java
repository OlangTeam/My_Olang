package com.yony.my_olang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class IdPw_Find extends AppCompatActivity {

    private static final String TAG = "IdPw_Find";

    private EditText et_name; //이름
    private EditText et_id; //아이디
    private EditText et_pass; //비밀번호
    private EditText et_hp; //핸드폰 번호
    private EditText et_send_hp; //핸드폰 인증 번호
    private Button btn_join,btn_login; //회원가입,로그인

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        et_name = (EditText) findViewById(R.id.et_name);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_hp = (EditText) findViewById(R.id.et_hp);
        et_send_hp = (EditText) findViewById(R.id.et_id_send_hp_check);
        et_send_hp = (EditText) findViewById(R.id.et_pass_send_hp_check);

        firebaseAuth = FirebaseAuth.getInstance();
    }

}