package com.example.myhealthdiary;

public class User {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String gender;
    private int height;
    private double weight;
    private String diabet_type;
    private int glucoseRangeMax;
    private int glucoseRangeMin;
    private int pressureRangeMax;
    private int pressureRangeMin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDiabet_type() {
        return diabet_type;
    }

    public void setDiabet_type(String diabet_type) {
        this.diabet_type = diabet_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", diabet_type='" + diabet_type + '\'' +
                '}';
    }

    public int getGlucoseRangeMax() {
        return glucoseRangeMax;
    }

    public void setGlucoseRangeMax(int glucoseRangeMax) {
        this.glucoseRangeMax = glucoseRangeMax;
    }

    public int getGlucoseRangeMin() {
        return glucoseRangeMin;
    }

    public void setGlucoseRangeMin(int glucoseRangeMin) {
        this.glucoseRangeMin = glucoseRangeMin;
    }

    public int getPressureRangeMax() {
        return pressureRangeMax;
    }

    public void setPressureRangeMax(int pressureRangeMax) {
        this.pressureRangeMax = pressureRangeMax;
    }

    public int getPressureRangeMin() {
        return pressureRangeMin;
    }

    public void setPressureRangeMin(int pressureRangeMin) {
        this.pressureRangeMin = pressureRangeMin;
    }
}
