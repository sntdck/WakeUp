package com.example.wakeme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton editHost, darkmode;
    private TextView title, hideTextMain, textView3;

    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("HOST_DATA", Context.MODE_PRIVATE);
        boolean hasHosts = sharedPreferences.getBoolean("HAS_HOSTS", false);

        if (hasHosts) {
            Intent intent = new Intent(MainActivity.this, HostPageActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.main_page);

        editHost = findViewById(R.id.editHost);
        darkmode = findViewById(R.id.changeBG);

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode", false);

        darkmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nightMode = !nightMode;
                if (nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    darkmode.setImageResource(R.drawable.light_mode_icon);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    darkmode.setImageResource(R.drawable.dark_theme);
                }
                editor = sharedPreferences.edit();
                editor.putBoolean("nightMode", nightMode);
                editor.apply();
            }
        });

        editHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditHostActivity.class);
                startActivity(intent);
            }
        });
    }
}