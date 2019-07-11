package com.example.semgtest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends MainActivity {
    private static final String TAG = "SigninActivity";

    private EditText mEtName_s;
    private EditText mEtPhone_s;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin);
        // 1.找到需要用到的控件
        mEtName_s = findViewById(R.id.et_act);
        mEtPhone_s = findViewById(R.id.et_pwd);
    }

    public void cl_reg(View view) {
        Intent in_reg = new Intent(SigninActivity.this, RegisterActivity.class);
        startActivity(in_reg);
    }

    public void cl_sig(View view) {
        String qq =  mEtName_s.getText().toString().trim();
        String password =  mEtPhone_s.getText().toString().trim();

        if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(password)) {
            Toast.makeText(this,"用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {

            // 模拟登录，当前输入的用户名和密码联网操作对比云端数据库是否匹配
            if (mDao.login(qq, password)) {
                Toast.makeText(this,"登录成功", Toast.LENGTH_SHORT).show();
                Intent in_sig = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(in_sig);
            } else {
                Toast.makeText(this,"登录失败", Toast.LENGTH_SHORT).show();
            }
        }


    }


}




