package com.pluralsight;

public class TVRemote {
    private String manufacturerName;
    private int currentChannelNumber;
    private double currentVolumeLevel;
    private String powerState;
    private String deviceOne;
    private String deviceTwo;
    private String currentChannelName;

    public TVRemote() {
        this.manufacturerName = "";
        this.currentChannelNumber = 0;
        this.currentVolumeLevel = 0.0;
        this.powerState = "";

    }

    public void Power(String powerState) {
        if (powerState.equalsIgnoreCase("Y")) {
            powerState = "OFF";
        } else {
            powerState = "ON";
        }
    }

    public void turnOff() {

    }

    public void changeChannel(int newChannel) {
        System.out.println("Current Channel: " + newChannel);
        getChannelName(newChannel);
        currentChannelNumber = newChannel;
    }

    public void adjustVolume(int newVolume) {

    }

    public void getChannelName(int currentChannelNumber) {
        if (currentChannelNumber == 3 || currentChannelNumber == 5 || currentChannelNumber == 8 || currentChannelNumber == 13 || currentChannelNumber == 25) {
            currentChannelName = "News Channel";
        } else {
            currentChannelName = "Generic Channel";
        }
    }

    public void finalResult(String deviceName, String manufacturerName, int currentDevice, double currentVolumeLevel) {
        if (currentDevice == 1) {
            deviceOne = deviceName + " TVRemote (" + manufacturerName +  "):\n" + "Status: " + powerState + ", Channel: " + currentChannelNumber + " (" + currentChannelName + "), Volume: " + currentVolumeLevel;
        } else if (currentDevice == 2) {
            deviceTwo = deviceName + " TVRemote (" + manufacturerName +  "):\n" + "Status: " + powerState + ", Channel: " + currentChannelNumber + " (" + currentChannelName + "), Volume: " + currentVolumeLevel;
            System.out.println(deviceOne + "\n" + deviceTwo);
        }

    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public int getCurrentChannelNumber() {
        return currentChannelNumber;
    }

    public double getCurrentVolumeLevel() {
        return currentVolumeLevel;
    }

    public String getPowerState() {
        return powerState;
    }
}
