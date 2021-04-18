package com.kevinleader.bgr.utility;

public class CurrentEpochTimestampExample {
    public static void main(String[] args) {
        // Get epoch timestamp using System.currentTimeMillis()
        long currentTimestamp = System.currentTimeMillis();
        int currentTimeSec = (int) (currentTimestamp / 1000);
        System.out.println("Current epoch timestamp in seconds: " + currentTimeSec);
    }
}
