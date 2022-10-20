package com.cindytech.main;

import android.content.Intent;
import android.os.Bundle;

import com.cindytech.main.alarm_setting;
import com.example.tanitest1.R;
import com.example.tanitest1.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    //references to buttons and other controls on the layout
    Button btn_add, btn_save;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("info", "MAIN CLASS");
    }

    //Go SETTINGS
    public void goToSetting(View v){
        Intent i = new Intent(this, alarm_setting.class);
        startActivity(i);
    }

}