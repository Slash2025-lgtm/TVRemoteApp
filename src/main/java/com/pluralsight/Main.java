package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TVRemote tvRemote = new TVRemote();
        int i = 0;
        boolean repeat = true;
        int device = 1;

        while (i < 2 && repeat == true) {
        System.out.println("Type Device Name: ");
        String deviceName = keyboard.nextLine().trim();

        System.out.println("Type Manufacturer Name: ");
        String manufacturer = keyboard.nextLine().trim();

        System.out.println("Connected to: " + deviceName + " (" + manufacturer + ")");

        System.out.println("Turn On Device? \nY [Yes] \nN [No]");
        String power = keyboard.nextLine().trim();

        if (power.equalsIgnoreCase("Y")) {
            tvRemote.Power("Y");
            System.out.println("Powered On");

            System.out.println("Enter in volume (0.0):");
            double volume = keyboard.nextDouble();

            int channel = 0;
            int count = 0;

            System.out.println("Options \n(+ [Increase] \n- [Decrease] \nM [Enter Type Mode Type] \nC [Confirm Channel])");
            while (count < 100) {
                String channelChange = keyboard.nextLine();
                if (channelChange.equalsIgnoreCase("+") && channel < 51) {
                    repeat = false;
                    channel += 1;
                    tvRemote.changeChannel(channel);
                } else if (channelChange.equalsIgnoreCase("-") && channel > 0) {
                    repeat = false;
                    channel -= 1;
                    tvRemote.changeChannel(channel);
                } else if (channelChange.equalsIgnoreCase("M")) {
                    repeat = false;
                    System.out.print("Enter Channel: ");
                    int typedChannel = keyboard.nextInt();
                    if (typedChannel > 0 && typedChannel <= 50) {
                        channel = typedChannel;
                    }
                } else if (channelChange.equalsIgnoreCase("C")) {
                    tvRemote.finalResult(deviceName, tvRemote.getPowerState(), device, 0.0);

                    if (device == 1) {
                        repeat = true;
                        count = 100;
                        System.out.println("Device Confirmed");
                        device += 1;
                        i += 1;
                    } else if (device == 2) {
                        repeat = false;
                        i += 1;
                        count = 100;
                    }
                } else {
                    System.out.println("Invalid Channel");
                }
            }
        } else {
            System.out.println("Powering off");
            tvRemote.Power("N");
        }
    }
    }
}
