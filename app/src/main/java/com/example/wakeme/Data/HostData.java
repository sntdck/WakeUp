package com.example.wakeme.Data;

public class HostData {
    private static HostData instance;

    private String hostName;
    private String ipAddress;
    private String macAddress;
    private String port;

    private HostData() {}

    public static HostData getInstance() {
        if (instance == null) {
            instance = new HostData();
        }
        return instance;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
