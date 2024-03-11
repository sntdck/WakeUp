package com.example.wakeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wakeme.Data.HostData;
import com.example.wakeme.Logic.TurnOn;

import javax.crypto.Mac;

public class EditHostActivity extends AppCompatActivity {
    private Button saveHost;
    private ImageButton backToMainPage;
    private TextView editIP, editMAC, edithostName, editPort;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        saveHost = findViewById(R.id.buttonSave);
        backToMainPage = findViewById(R.id.backButton);

        editIP = findViewById(R.id.editIPAddress);
        editMAC = findViewById(R.id.editMACAddress);
        edithostName = findViewById(R.id.editHostName);
        editPort = findViewById(R.id.editPort);

        backToMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditHostActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        saveHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hostName = edithostName.getText().toString().trim();
                String ipAddress = editIP.getText().toString().trim();
                String macAddress = editMAC.getText().toString().trim();
                String port = editPort.getText().toString().trim();

                if (!hostName.isEmpty() && !ipAddress.isEmpty() && !macAddress.isEmpty() && !port.isEmpty()){

                    HostData hostData = HostData.getInstance();
                    hostData.setHostName(hostName);
                    hostData.setIpAddress(ipAddress);
                    hostData.setMacAddress(macAddress);
                    hostData.setPort(port);

                    Intent intent = new Intent(EditHostActivity.this, HostPageActivity.class);
                    intent.putExtra("HOST_NAME", hostName);
                    startActivity(intent);
                    TurnOn.printHostData();

                }else {
                    Toast.makeText(EditHostActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}