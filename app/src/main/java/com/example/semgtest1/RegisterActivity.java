package com.example.semgtest1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends BaseActivity {

    private EditText mEtName_r;
    private EditText mEtPhone_r;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        // 1.找到需要用到的控件
        mEtName_r = findViewById(R.id.et_nact);
        mEtPhone_r = findViewById(R.id.et_npwd);
    }

    //@Override
    public void cl_reg_r(View view) {
        String name = mEtName_r.getText().toString().trim();
        String phone = mEtPhone_r.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if (mDao.queryName(name)) {

        } else {
            mDao.add(name, phone);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            Intent in_reg_r = new Intent(RegisterActivity.this, SigninActivity.class);
            startActivity(in_reg_r);
        }
    }
}





