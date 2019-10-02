package com.bank.manager.common;

public enum CountType {
    FIVE(5),
    ONEHOUR(60),
    TWOHOUR(120),
    DAY(1440);

    int minute;

    CountType(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setMessage(int minute) {
        this.minute = minute;
    }
}
