package com.example.wakeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wakeme.Logic.TurnOn;

public class HostPageActivity extends AppCompatActivity {

    private TextView changeHostName;
    private ImageButton editHost, restartButton, sleepButton, turnOn;

    private ImageButton deleteHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_page);

        changeHostName = findViewById(R.id.changeHostName);
        editHost = findViewById(R.id.editHostButton);
        turnOn = findViewById(R.id.turnOnButton);
        restartButton= findViewById(R.id.restartButton);
        sleepButton = findViewById(R.id.sleepButton);
        deleteHost = findViewById(R.id.deleteHostButton);

        String hostName = getIntent().getStringExtra("HOST_NAME");
        String changeName = getIntent().getStringExtra("CHANGE_HOST_NAME");

        if (hostName != null) {
            changeHostName.setText(hostName);
        } else if (changeName != null) {
            changeHostName.setText(changeName);
        }

        editHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HostPageActivity.this, ChangeHostActivity.class);
                startActivity(intent);

            }
        });

        turnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Thread thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          TurnOn.wakeUp();
                      } catch (Exception e){
                          e.printStackTrace();
                      }
                  }
              });
              thread.start();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TurnOn.reboot();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
               thread.start();
            }
        });

        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TurnOn.Sleep();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });

        deleteHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HostPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
