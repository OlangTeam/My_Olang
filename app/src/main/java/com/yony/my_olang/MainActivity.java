package com.yony.my_olang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private EditText et_id; //아이디
    private EditText et_pass; //비밀번호
    private Button buttonLogIn; //로그인
    private Button buttonIdFound; //ID찾기
    private Button buttonPwFound; //PW찾기
    private Button buttonSignUp; //회원가입

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase 연동
        firebaseAuth = FirebaseAuth.getInstance();

        //id,pw 입력한값 얻어오기
        et_id = (EditText) findViewById(R.id.et_id);
        et_pass = (EditText) findViewById(R.id.et_pass);

        //아이디 찾기
        buttonIdFound = (Button) findViewById(R.id.FoundID);

        buttonIdFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IdPw_Find.class));
            }
        });

        //비밀번호 찾기
        buttonPwFound = (Button) findViewById(R.id.FoundPW);

        buttonPwFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IdPw_Find.class);
                startActivity(intent);
            }
        });

        //회원가입 버튼 누르면
        buttonSignUp = (Button) findViewById(R.id.btn_register);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SignUpActivity 연결
                Intent intent = new Intent(MainActivity.this, Join_View.class);
                startActivity(intent);
            }
        });

        //로그인 버튼 누르면
        buttonLogIn = (Button) findViewById(R.id.btn_login);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_id.getText().toString().equals("") && !et_pass.getText().toString().equals("")) {
                    loginUser(et_id.getText().toString(), et_pass.getText().toString());
                } else {
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, MainView.class);
                    startActivity(intent);
                    finish();
                } else {
                }
            }
        };
    }

    public void loginUser(String id,String password) {
        firebaseAuth.signInWithEmailAndPassword(id, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            firebaseAuth.addAuthStateListener(firebaseAuthListener);
                        } else {
                            // 로그인 실패
                            Toast.makeText(MainActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (firebaseAuthListener != null) {
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }
}
