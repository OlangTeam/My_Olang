package com.yony.my_olang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class JoinView extends AppCompatActivity {

    // 파이어베이스 데이터베이스 연동
    private FirebaseAuth firebaseAuth;

    private Button login_success,login_cancle,send_hp_check,found_address,studentId,btn_id_check;
    private EditText et_name,et_id,et_pass,et_repass,et_nickname,et_email,et_hp,et_send_hp,et_age;
    private TextView tv_pass;
    private RadioButton radio_girl,radio_boy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_view);

        //파이어베이스 인증 객체 선언
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        et_id = (EditText) findViewById(R.id.et_id); //아이디
        et_name = (EditText) findViewById(R.id.et_name); //이름
        et_pass = (EditText) findViewById(R.id.et_pass); //이름
        et_pass = (EditText) findViewById(R.id.et_pass); //이름
        et_pass = (EditText) findViewById(R.id.et_pass); //이름
        login_success = (Button) findViewById(R.id.join_success); //로그인 버튼

        login_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_id.getText().toString().equals("") && !et_pass.getText().toString().equals("")) {
                    // 이메일과 비밀번호가 공백이 아닌 경우
                    createUser(et_id.getText().toString(), et_pass.getText().toString(), tv_pass);
                }
                else {
                    // 이메일과 비밀번호가 공백인 경우
                    Toast.makeText(JoinView.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void createUser(String id, String password, TextView tv_pass) {
        firebaseAuth.createUserWithEmailAndPassword(id, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공시
                            Toast.makeText(JoinView.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else {
                            // 계정이 중복된 경우
                            if (task.getException().toString() != null)
                                Toast.makeText(JoinView.this, "회원가입 실패.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
