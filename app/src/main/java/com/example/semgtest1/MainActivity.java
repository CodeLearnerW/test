package com.example.semgtest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semgtest1.dao.ContactInfoDao;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void cl_pif(View view) {
        Intent in_main = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(in_main);
    }


}
