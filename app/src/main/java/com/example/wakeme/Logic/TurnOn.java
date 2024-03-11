package com.example.wakeme.Logic;

import com.example.wakeme.Data.HostData;

public class TurnOn {

    public static void printHostData() {
        HostData hostData = HostData.getInstance();
        String name = hostData.getHostName();
        String ipAddress = hostData.getIpAddress();
        String macAddress = hostData.getMacAddress();
        String port = hostData.getPort();

        System.out.println("Name: " + name);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Port: " + port);
    }

    public static void wakeUp() {

        HostData hostData = HostData.getInstance();
        String ipAddress = hostData.getIpAddress();
        String macAddress = hostData.getMacAddress();
        String port = hostData.getPort();

        WakeOnLan.wakeUp(ipAddress, macAddress, Integer.parseInt(port));
    }

    public static void reboot() {
        HostData hostData = HostData.getInstance();
        String ipAddress = hostData.getIpAddress();
        String macAddress = hostData.getMacAddress();
        String port = hostData.getPort();
        WakeOnLanR.wakeOnLanForReboot(ipAddress, macAddress, Integer.parseInt(port));
    }

    public static void Sleep(){
        HostData hostData = HostData.getInstance();
        String ipAddress = hostData.getIpAddress();
        String macAddress = hostData.getMacAddress();
        String port = hostData.getPort();
        WakeOnLanS.wakeOnLanForSleep(ipAddress, macAddress, Integer.parseInt(port));
    }
}
