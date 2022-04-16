package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Activity_view extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();
        String url = intent.getDataString();
        String msg = intent.getStringExtra(activityLogin1.EXTRA_MESSAGE);
        EditText txtMsg = findViewById(R.id.textmsg);
        EditText txtUrl = findViewById(R.id.texturl);
        txtMsg.setText(msg);
        txtUrl.setText(url);
    }

}