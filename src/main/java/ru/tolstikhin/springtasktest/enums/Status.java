package ru.tolstikhin.springtasktest.enums;

public enum Status {
    ONLINE("Онлайн"),
    OFFLINE("Офлайн");

    private String statusString;

    Status(String statusString) {
        this.statusString = statusString;
    }

    public String getStatusString() {
        return statusString;
    }
}
