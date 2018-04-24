package com.boss.rains;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class loginSuccActivity extends AppCompatActivity {
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        Log.i("Rains: MainActivity", "004");
        tvInfo = findViewById(R.id.tv_show);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String pwd = intent.getStringExtra("userpwd");
        boolean isMarried = intent.getBooleanExtra("isMarried", true);
        int old = intent.getIntExtra("old", 0);
        tvInfo.setText(username + "你好！你的密码是"
                + pwd + ",婚姻状况：" + (isMarried ? "已婚":"未婚") + ",年龄：" + old);
        Log.i("Rains: MainActivity", "005");
    }
}
