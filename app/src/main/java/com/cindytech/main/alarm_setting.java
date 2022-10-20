package com.cindytech.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tanitest1.R;

public class alarm_setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_setting);
    }

    public void save (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}