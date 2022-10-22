package com.cindytech.main;

import static com.example.tanitest1.R.id.btn_save;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cindytech.database.DataBaseHelper;
import com.cindytech.model.Model;
import com.example.tanitest1.R;

public class Alarm_Settings extends AppCompatActivity {

    final private static String ID = "1";
    //references to buttons and other controls on the layout
    Button btn_save;
    EditText et_number, et_arm, et_disarm, et_night, et_day, et_status, et_enable, et_disable, et_time, et_password;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(Alarm_Settings.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_setting);

        dataBaseHelper.uploadSettings();

        btn_save = findViewById(R.id.btn_save);
        et_number = findViewById(R.id.et_number);
        et_arm = findViewById(R.id.et_arm);
        et_disarm = findViewById(R.id.et_disarm);
        et_night = findViewById(R.id.et_night);
        et_day = findViewById(R.id.et_day);
        et_status = findViewById(R.id.et_status);
        et_enable = findViewById(R.id.et_enable);
        et_disable = findViewById(R.id.et_disable);
        et_time = findViewById(R.id.et_time);
        et_password = findViewById(R.id.et_password);


        //button listeners
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                String arm = et_arm.getText().toString();
                String disarm = et_disarm.getText().toString();
                String night = et_night.getText().toString();
                String day = et_day.getText().toString();
                String status = et_status.getText().toString();
                String enable = et_enable.getText().toString();
                String disable = et_disable.getText().toString();
                String time = et_time.getText().toString();
                String password = et_password.getText().toString();

                Model model;
                try {
                    model = new Model(1, number, arm, disarm, night, day, status, enable, disable, time, password);
                    Log.d("info NUMBER", model.getNumber());
                    Toast.makeText(Alarm_Settings.this, model.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(Alarm_Settings.this, "ERROR CREATING MODEL", Toast.LENGTH_SHORT).show();
                    model = new Model(-1, "error", "error"," error", "error", "error", "error", "error", "error", "error", "error");
                }


                //boolean success = dataBaseHelper.addOne(model);
                dataBaseHelper.updateModel(model);

                Toast.makeText(Alarm_Settings.this, "SUCCESS", Toast.LENGTH_SHORT).show();

                turnBack();
            }
        });
    }


    public void turnBack (){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}