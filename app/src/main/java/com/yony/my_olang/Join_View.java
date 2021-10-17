package com.yony.my_olang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Join_View<FirebaseDatabase> extends AppCompatActivity {

    // 파이어베이스 데이터베이스 연동
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    //DatabaseReference는 데이터베이스의 특정 위치로 연결하는 거라고 생각하면 된다.
    //현재 연결은 데이터베이스에만 딱 연결해놓고
    //키값(테이블 또는 속성)의 위치 까지는 들어가지는 않은 모습이다.
    private DatabaseReference databaseReference = database.getReference();

    private FirebaseAuth firebaseAuth;
    private EditText id;
    private EditText password;
    private EditText name;
    private EditText email;
    private EditText hp;
    private Button overcheck,found_address,hp_check,login_success,login_cancle,studentid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_view);

        firebaseAuth = FirebaseAuth.getInstance();

        id = (EditText) findViewById(R.id.et_id); //아이디
        name = (EditText) findViewById(R.id.editTextTextPersonName9); //이름
        password = (EditText) findViewById(R.id.et_pass); //비밀번호
        email = (EditText) findViewById(R.id.editTextTextPersonName10); //이메일
        hp = (EditText) findViewById(R.id.editTextTextPersonName11); //핸폰

        overcheck = (Button) findViewById(R.id.overcheck);//아이디 중복체크
        hp_check = (Button) findViewById(R.id.hp_check); //핸드폰 인증
        found_address = (Button) findViewById(R.id.found_address); //주소
        login_success = (Button) findViewById(R.id.btn_register); //회원가입 성공
        login_cancle = (Button) findViewById(R.id.join_cancel); //회원가입 취소
        studentid = (Button) findViewById(R.id.studentId); //학생증 업로드

        overcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().equals("") && !password.getText().toString().equals("") && !name.getText().toString().equals("")
                        && !email.getText().toString().equals("") && !hp.getText().toString().equals("")) {
                    // editText가 공백이 아닌 경우
                    createUser(id.getText().toString(), password.getText().toString(), name.getText().toString(), email.getText().toString(), hp.getText().toString());
                } else {
                    // editText가 공백인 경우
                    Toast.makeText(Join_View.this, "빈칸을 입력하시오.", Toast.LENGTH_LONG).show();
                }
            }
        });


        //회원가입 버튼 클릭시
        login_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().equals("") && !password.getText().toString().equals("") && !name.getText().toString().equals("")
                        && !email.getText().toString().equals("") && !hp.getText().toString().equals("")) {
                    // editText가 공백이 아닌 경우
                    createUser(id.getText().toString(), password.getText().toString(), name.getText().toString(), email.getText().toString(), hp.getText().toString());
                } else {
                    // editText가 공백인 경우
                    Toast.makeText(Join_View.this, "빈칸을 입력하시오.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




    //값을 파이어베이스 Realtime database로 넘기는 함수
    public void createUser(String id,String password, String name, String email, String hp) {

        firebaseAuth.createUserWithEmailAndPassword(id,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공시
                            Toast.makeText(Join_View.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            // 계정이 중복된 경우
                            Toast.makeText(Join_View.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
  }

