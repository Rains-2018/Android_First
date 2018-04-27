package com.boss.rains;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private TextView tvForgot;

    //private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Activity创建标准两句代码，用于初始化和将layout布局显示在界面上
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //绑定xml文件中的资源
        etUsername = (EditText) findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
        //btnRegister = findViewById(R.id.btn_register);
        tvRegister = findViewById(R.id.tv_register);
        tvForgot = findViewById(R.id.tv_findpwd);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReigisterActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //trime()表示去掉字符序列左边和右边的空格
                String username = etUsername.getText().toString().trim();
                String userpwd = etPassword.getText().toString().trim();
                Log.i("Rains: MainActivity", "001");

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(userpwd)) {
                    Log.i("Rains: MainActivity", "002");
                    //intent 运输大队长 Activity之间数据交互
                    Intent intent = new Intent(MainActivity.this, loginSuccActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("userpwd", userpwd);
                    intent.putExtra("isMarreid", true);
                    intent.putExtra("old", 30);
                    startActivity(intent);
                    // startActivityForResult(intent, REQUEST_CODE);
                    Log.i("Rains: MainActivity", "003");
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //重写，注意名字不能写错了，用于接收Activit 通过Intent回传的数据
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == REQUEST_CODE) {
            if (resultcode == RESULT_OK) {
                String dt = data.getStringExtra("key");
            }
        }
    }
}
