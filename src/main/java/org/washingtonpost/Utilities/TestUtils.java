package org.washingtonpost.Utilities;

import java.io.IOException;

public class TestUtils {
    ProcessBuilder pb;
    Process process;

    public  boolean wifiOnOff(String state) throws IOException {
        if (state.equalsIgnoreCase("OFF")) {
            pb = new ProcessBuilder("netsh", "interface", "set", "interface", "name=\"Wi-Fi\"", "admin=disable");
            process = pb.start();
            try {
                process.waitFor();
                System.out.println("Wi-Fi turned OFF");
            } catch (InterruptedException e) {
                System.out.println("Wi-fi Turn OFF Error : " + e);
            }
            return true;
        } else if (state.equalsIgnoreCase("ON")) {
            pb = new ProcessBuilder("netsh", "interface", "set", "interface", "name=\"Wi-Fi\"", "admin=enable");
            process = pb.start();
            try {
                process.waitFor();
                System.out.println("Wi-Fi turned ON");
            } catch (InterruptedException e) {
                System.out.println("Wi-fi Turn ON Error : " + e);
            }
            return true;
        } else {
            System.out.println("Wi-Fi Status to set [" + state + "] is irrelevant");
            return false;
        }
    }
}
