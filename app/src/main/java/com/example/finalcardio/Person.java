package com.example.finalcardio;

import java.time.LocalDateTime;
public class Person {
    private float heartRate;
    private int age;
    private int effort;
    private LocalDateTime date;

    public float getHeartRate() {
        return heartRate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }
}

