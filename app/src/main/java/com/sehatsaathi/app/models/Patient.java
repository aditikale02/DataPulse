package com.sehatsaathi.app.models;

public class Patient {
    private final String name;
    private final String medicationInfo;
    private final String time;
    private final String avatarText;

    public Patient(String name, String medicationInfo, String time, String avatarText) {
        this.name = name;
        this.medicationInfo = medicationInfo;
        this.time = time;
        this.avatarText = avatarText;
    }

    public String getName() {
        return name;
    }

    public String getMedicationInfo() {
        return medicationInfo;
    }

    public String getTime() {
        return time;
    }

    public String getAvatarText() {
        return avatarText;
    }
}
