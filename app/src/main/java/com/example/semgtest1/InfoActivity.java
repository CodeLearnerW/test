package com.example.semgtest1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InfoActivity extends BaseActivity {
    private static final String TAG = "InfoActivity";

    private EditText mEtName_c;
    private EditText mEtPhone_c;
    private EditText mEtnPhone_c;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        // 1.找到需要用到的控件
        mEtName_c = findViewById(R.id.et_act_c);
        mEtPhone_c = findViewById(R.id.et_pwd_c);
        mEtnPhone_c = findViewById(R.id.et_npwd_c);
    }


    public void cl_chg(View view) {
        String qq =  mEtName_c.getText().toString().trim();
        String password =  mEtPhone_c.getText().toString().trim();
        String npassword =  mEtnPhone_c.getText().toString().trim();

        if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(password)) {
            Toast.makeText(this,"用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {

            if (mDao.login(qq, password)) {
                mDao.update(qq, npassword);
                Toast.makeText(this,"修改成功", Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"请重新登录", Toast.LENGTH_SHORT).show();
                ActivityCollector.finishAll();
                //结束进程
                //android.os.Process.killProcess(android.os.Process.myPid());

                Intent in_sig_s = new Intent(InfoActivity.this, SigninActivity.class);
                startActivity(in_sig_s);
            } else {
                Toast.makeText(this,"修改失败", Toast.LENGTH_SHORT).show();
            }
        }


    }

    
}






