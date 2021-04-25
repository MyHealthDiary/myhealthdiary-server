package com.example.myhealthdiary;


import java.sql.Date;

public class HealthData {

    private String userEmail;
    private Date date;
    private double blood_glucose;
    private double hba1c;
    private int heart_rate;
    private int bloodpressure_max;
    private int bloodpressure_min;
    private int carbohydrates;
    private int steps;
    private int sleep;
    private String exercise_type;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getBlood_glucose() {
        return blood_glucose;
    }

    public void setBlood_glucose(double blood_glucose) {
        this.blood_glucose = blood_glucose;
    }

    public double getHba1c() {
        return hba1c;
    }

    public void setHba1c(double hba1c) {
        this.hba1c = hba1c;
    }

    public int getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }

    public int getBloodpressure_max() {
        return bloodpressure_max;
    }

    public void setBloodpressure_max(int bloodpressure_max) {
        this.bloodpressure_max = bloodpressure_max;
    }

    public int getBloodpressure_min() {
        return bloodpressure_min;
    }

    public void setBloodpressure_min(int bloodpressure_min) {
        this.bloodpressure_min = bloodpressure_min;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public String getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.exercise_type = exercise_type;
    }

    @Override
    public String toString() {
        return "HealthData{" +
                "userEmail=" + userEmail +
                ", blood_glucose=" + blood_glucose +
                ", hba1c=" + hba1c +
                ", heart_rate=" + heart_rate +
                ", bloodpressure_max=" + bloodpressure_max +
                ", bloodpressure_min=" + bloodpressure_min +
                ", carbohydrates=" + carbohydrates +
                ", steps=" + steps +
                ", sleep=" + sleep +
                ", exercise_type='" + exercise_type + '\'' +
                '}';
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
