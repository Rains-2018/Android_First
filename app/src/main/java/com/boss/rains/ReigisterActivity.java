package com.boss.rains;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ReigisterActivity extends AppCompatActivity {
    private Button btRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reigister);

        btRegister = findViewById(R.id.bt_reg_ok);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReigisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
