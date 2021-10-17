package com.yony.my_olang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class JoinView extends AppCompatActivity {

    private static final String TAG = "JoinView";

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
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");

        et_id = (EditText) findViewById(R.id.et_id); //아이디
        et_name = (EditText) findViewById(R.id.et_name); //이름
        et_pass = (EditText) findViewById(R.id.et_pass); //이름
        et_repass = (EditText) findViewById(R.id.et_repass); //이름
        et_nickname = (EditText) findViewById(R.id.et_nickname); //이름
        login_success = (Button) findViewById(R.id.join_success); //로그인 버튼

        login_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = et_id.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();
                String repass = et_repass.getText().toString().trim();

                if(pass.equals(repass)) {
                    Log.d(TAG, "등록 버튼 " + id + " , " + pass);
                    final ProgressDialog mDialog = new ProgressDialog(JoinView.this);
                    mDialog.setMessage("가입중입니다...");
                    mDialog.show();

                    //파이어베이스에 신규계정 등록하기
                    firebaseAuth.createUserWithEmailAndPassword(id, pass).addOnCompleteListener(JoinView.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //가입 성공시
                            if (task.isSuccessful()) {
                                mDialog.dismiss();

                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();
                                String name = et_id.getText().toString().trim();

                                //해쉬맵 테이블을 파이어베이스 데이터베이스에 저장
                                HashMap<Object,String> hashMap = new HashMap<>();

                                hashMap.put("uid",uid);
                                hashMap.put("email",email);
                                hashMap.put("name",name);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();//데이터 베이스에 접근 권한 갖기
                                DatabaseReference reference = database.getReference("Users");//데이터 베이스 Users라는 인스턴스 갖기
                                reference.child(uid).setValue(hashMap); //자식에 hashmap 집어넣기


                                //가입이 이루어져을시 가입 화면을 빠져나감.
                                Intent intent = new Intent(JoinView.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(JoinView.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                            } else {
                                mDialog.dismiss();
                                Toast.makeText(JoinView.this, "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                return;  //해당 메소드 진행을 멈추고 빠져나감.

                            }

                        }
                    });

                    //비밀번호 오류시
                }else{

                    Toast.makeText(JoinView.this, "비밀번호가 틀렸습니다. 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

}