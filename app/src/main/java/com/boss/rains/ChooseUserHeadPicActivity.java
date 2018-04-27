package com.boss.rains;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//implements 是实现OnClickListener接口的意思
public class ChooseUserHeadPicActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imgHeadOne;
    private ImageView imgHeadTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseuserheadpic);

        imgHeadOne = findViewById(R.id.img_ch_01);
        imgHeadTwo = findViewById(R.id.img_ch_02);

        imgHeadOne.setOnClickListener(this);
        imgHeadTwo.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.img_ch_01:
                returnData(R.drawable.head);
                break;
            case R.id.img_ch_02:
                returnData(R.mipmap.ic_launcher);
                break;
        }
    }

    private  void returnData(int imgId){
        Intent intent = new Intent();
        intent.putExtra("imageId", imgId);
        setResult(RESULT_OK, intent);
        finish();
    }
}
