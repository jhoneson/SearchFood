package com.example.scxh.mybaidu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class QishiActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar mtoolbar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qishi);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar1);
        button = (Button) findViewById(R.id.qishiBtn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qishiBtn:
                Intent intent = new Intent(QishiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
        }
    }
}
