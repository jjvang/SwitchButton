package com.example.ojboba.switchbutton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Switch simpleSwitch1;
    boolean switchState2 = false;
    SharedPreferences sharedPrefs;
    int language = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate view's
        simpleSwitch1 = (Switch) findViewById(R.id.simpleSwitch1);

        // Having two preference managers or preferences fucks up your code
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        simpleSwitch1.setChecked(sharedPrefs.getBoolean("NameOfThingToSave",false));

        switchState2 = sharedPrefs.getBoolean("NameOfThingToSave", false);

        final ToggleButton tgbutton;
        tgbutton = (ToggleButton) findViewById(R.id.toggle);

//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        tgbutton.setChecked(sharedPrefs.getBoolean("toggleButton", false));  //default is false

        tgbutton.setOnClickListener(new ToggleButton.OnClickListener() {
            public void onClick(View v) {
                sharedPrefs.edit().putBoolean("toggleButton", tgbutton.isChecked()).commit();
            }
        });

//        tgbutton.setOnClickListener(new ToggleButton.OnClickListener() {
//            public void onClick(View v) {
//                SharedPreferences sharedPreferences = PreferenceManager
//                        .getDefaultSharedPreferences(getApplicationContext());
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putBoolean("toggleButton", tgbutton.isChecked());
//                editor.commit();
//            }
//        });

        simpleSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    language = 0;
                    sharedPrefs.edit().putBoolean("NameOfThingToSave", true).commit();
                    Toast.makeText(MainActivity.this, "This is on " + language + switchState2, Toast.LENGTH_SHORT).show();
                } else {
                    language = 10;
                    sharedPrefs.edit().putBoolean("NameOfThingToSave", false).commit();
                    Toast.makeText(MainActivity.this, "This is off " + language + switchState2, Toast.LENGTH_SHORT).show();
                }
            }
        });

//        simpleSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putBoolean("NameOfThingToSave", true);
//                editor.commit();
//                    Toast.makeText(MainActivity.this, "This is on " + switchState2, Toast.LENGTH_SHORT).show();
//                } else {
//                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putBoolean("NameOfThingToSave", false);
//                    editor.commit();
//                    Toast.makeText(MainActivity.this, "This is on " + switchState2, Toast.LENGTH_SHORT).show();   Toast.makeText(MainActivity.this, "This is off " + switchState2, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}

//        simpleSwitch2 = (Switch) findViewById(R.id.simpleSwitch2);
//        submit = (Button) findViewById(R.id.submitButton);

//submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String statusSwitch1, statusSwitch2;
//                if (simpleSwitch1.isChecked())
//                    statusSwitch1 = simpleSwitch1.getTextOn().toString();
//                else
//                    statusSwitch1 = simpleSwitch1.getTextOff().toString();
//                if (simpleSwitch2.isChecked())
//                    statusSwitch2 = simpleSwitch2.getTextOn().toString();
//                else
//                    statusSwitch2 = simpleSwitch2.getTextOff().toString();
//                Toast.makeText(getApplicationContext(), "Switch1 :" + statusSwitch1 + "\n" + "Switch2 :" + statusSwitch2, Toast.LENGTH_LONG).show(); // display the current state for switch's
//            }
//        });


//    boolean switchState = sharedPrefs.getBoolean("NameOfThingToSave2", false);
//
//if(switchState){
//        Toast.makeText(this, "bt2 is on", Toast.LENGTH_SHORT).show();
//        } else {
//        Toast.makeText(this, "bt2 is off", Toast.LENGTH_SHORT).show();
//        }

//simpleSwitch2.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View arg0) {
//        SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz", MODE_PRIVATE).edit();
//        editor.putBoolean("NameOfThingToSave2", simpleSwitch2.isChecked());
//        editor.commit();
//        }
//        });
