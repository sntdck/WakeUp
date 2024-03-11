
package com.example.wakeme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wakeme.Data.HostData;
import com.example.wakeme.Logic.TurnOn;

public class ChangeHostActivity extends AppCompatActivity {

    private Button saveButtonChange;
    private TextView changeName, changeIP, changeMac, changePort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_host_page);

        saveButtonChange = findViewById(R.id.buttonSaveChange);
        changeName = findViewById(R.id.changeHostName);
        changeIP = findViewById(R.id.changeIPAddress);
        changeMac = findViewById(R.id.changeMACAddress);
        changePort = findViewById(R.id.changePort);

        HostData hostData = HostData.getInstance();
        changeName.setText(hostData.getHostName());
        changeIP.setText(hostData.getIpAddress());
        changeMac.setText(hostData.getMacAddress());
        changePort.setText(hostData.getPort());

        saveButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String changeHostName = changeName.getText().toString().trim();
                String changeIPAddress = changeIP.getText().toString().trim();
                String changeMacAddress = changeMac.getText().toString().trim();
                String changePortN = changePort.getText().toString().trim();

                HostData hostData = HostData.getInstance();
                hostData.setHostName(changeHostName);
                hostData.setIpAddress(changeIPAddress);
                hostData.setMacAddress(changeMacAddress);
                hostData.setPort(changePortN);

                Intent intent = new Intent(ChangeHostActivity.this, HostPageActivity.class);
                intent.putExtra("CHANGE_HOST_NAME", changeHostName);
                startActivity(intent);
                TurnOn.printHostData();
            }
        });
    }
}
