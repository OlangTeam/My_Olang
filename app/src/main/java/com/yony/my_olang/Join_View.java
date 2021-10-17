package com.yony.my_olang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Join_View extends AppCompatActivity {

    // 파이어베이스 데이터베이스 연동
    private FirebaseAuth firebaseAuth;

    private Button overcheck,found_address,hp_check,login_success,login_cancle,studentid;

    EditText et_name,et_id,et_pass,et_repass,et_nickname,et_email,et_hp,ex_hpwriter,et_age;
    Button send_hp_check;
    RadioButton radio_girl,radio_boy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_view);

        //파이어베이스 인증 객체 선언
        firebaseAuth = FirebaseAuth.getInstance();

        findViewById(R.id.join_success).setOnClickListener(onClickListener);

        String id = ((EditText) findViewById(R.id.et_id)).getText().toString(); //아이디
        String name = ((EditText) findViewById(R.id.et_name)).getText().toString(); //이름
        String password = ((EditText) findViewById(R.id.et_pass)).getText().toString(); //비밀번호
        String repassword = ((EditText) findViewById(R.id.et_repass)).getText().toString();
        String email = ((EditText) findViewById(R.id.et_email)).getText().toString(); //이메일
        String hp = ((EditText) findViewById(R.id.et_hp)).getText().toString(); //핸폰
        String age = ((EditText) findViewById(R.id.et_age)).getText().toString(); //나이


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.join_success:
                    Join_View();
                    break;
            }
        }
    };

    private void Join_View() {

        String id = ((EditText) findViewById(R.id.et_id)).getText().toString(); //아이디
        String name = ((EditText) findViewById(R.id.et_name)).getText().toString(); //이름
        String password = ((EditText) findViewById(R.id.et_pass)).getText().toString(); //비밀번호
        String repassword = ((EditText) findViewById(R.id.et_repass)).getText().toString();
        String email = ((EditText) findViewById(R.id.et_email)).getText().toString(); //이메일
        String hp = ((EditText) findViewById(R.id.et_hp)).getText().toString(); //핸폰
        String age = ((EditText) findViewById(R.id.et_age)).getText().toString(); //나이

        overcheck = (Button) findViewById(R.id.overcheck);//아이디 중복체크
        hp_check = (Button) findViewById(R.id.hp_check); //핸드폰 인증
        found_address = (Button) findViewById(R.id.found_address); //주소
        login_success = (Button) findViewById(R.id.join_success); //로그인 성공
        login_cancle = (Button) findViewById(R.id.join_cancle); //로그인 취소
        studentid = (Button) findViewById(R.id.studentId); //학생증 업로드


        private void createUser(String id,String password, )


        //값이 다 입력 된 후 repass 비교
        if (id.length() > 0 && password.length() > 0 && repassword.length() > 0 && hp.length() > 0
            && name.length() > 0 && email.length() > 0 && age.length() > 0) {
            if (password.equals(repassword)) {
                firebaseAuth.createUserWithEmailAndPassword(id, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공시
                            Toast.makeText(Join_View.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException().toString() != null) {
                                Toast.makeText(Join_View.this, "회원가입 실패.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            } else {
                Toast.makeText(Join_View.this, "비번 불일치", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Join_View.this, "비번 확인하세요", Toast.LENGTH_SHORT).show();
        }
    }
}

