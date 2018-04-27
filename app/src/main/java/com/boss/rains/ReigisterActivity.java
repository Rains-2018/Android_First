package com.boss.rains;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ReigisterActivity extends AppCompatActivity {
    private  static final int REQUEST_CODE = 1;
    private Button btRegister;
    private ImageButton imgSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reigister);

        btRegister = findViewById(R.id.bt_reg_ok);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ReigisterActivity.this, MainActivity.class);
                // startActivity(intent);

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        imgSelect = findViewById(R.id.img_reg_pic);

        imgSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReigisterActivity.this, ChooseUserHeadPicActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        int imgId  = data.getIntExtra("imageId",R.drawable.head);
        imgSelect.setImageResource(imgId);
        //
    }

}
