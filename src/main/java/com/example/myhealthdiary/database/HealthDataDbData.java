package com.example.myhealthdiary.database;

import com.example.myhealthdiary.HealthData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HealthDataDbData {

    private final Connection connection;

    public HealthDataDbData(Connection connection) {
        this.connection = connection;
    }

    public List<HealthData> findUserDataByDay(int userid, int day, int month, int year) { // to change
        String dateBuilder = year + "-" + month + "-" + day;
        Date formattedDate = java.sql.Date.valueOf(dateBuilder);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.healthdata WHERE userid= ? AND date= ? order by dataid DESC");
            preparedStatement.setInt(1, userid);
            preparedStatement.setDate(2, (java.sql.Date) formattedDate);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;

            LinkedList healthDataListByDay = new LinkedList<>();
            while (resultSet.next()) {
                HealthData healthData = new HealthData();
                healthData.setUserEmail(resultSet.getString(2));
                healthData.setDate(resultSet.getDate(3));
                healthData.setBlood_glucose(resultSet.getDouble(4));
                healthData.setHba1c(resultSet.getDouble(5));
                healthData.setHeart_rate(resultSet.getInt(6));
                healthData.setBloodpressure_max(resultSet.getInt(7));
                healthData.setBloodpressure_min(resultSet.getInt(8));
                healthData.setCarbohydrates(resultSet.getInt(9));
                healthData.setSteps(resultSet.getInt(10));
                healthData.setSleep(resultSet.getInt(11));
                healthData.setExercise_type(resultSet.getString(12));
                healthDataListByDay.add(healthData);
            }
            return healthDataListByDay;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HealthData findHealthDataByUser(String userEmail) {
        HealthData returnData = new HealthData();
        double blood_glucose = 0;
        double hba1c = 0;
        int heart_rate = 0;
        int bloodpressure_max = 0;
        int bloodpressure_min = 0;
        int carbohydrates = 0;
        int steps = 0;
        int sleep = 0;
        String exercise_type = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.healthdata WHERE userEmail= ? order by dataid DESC limit 30");
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                try {
                    if (blood_glucose == 0) {
                        blood_glucose = resultSet.getDouble(4);
                    }
                    if (hba1c == 0) {
                        hba1c = resultSet.getDouble(5);
                    }
                    if (heart_rate == 0) {
                        heart_rate = resultSet.getInt(6);
                    }
                    if (bloodpressure_max == 0) {
                        bloodpressure_max = resultSet.getInt(7);
                    }
                    if (bloodpressure_min == 0) {
                        bloodpressure_min = resultSet.getInt(8);
                    }
                    if (carbohydrates == 0) {
                        carbohydrates = resultSet.getInt(9);
                        System.out.println(carbohydrates);
                    }
                    if (steps == 0) {
                        steps = resultSet.getInt(10);
                    }
                    if (sleep == 0) {
                        sleep = resultSet.getInt(11);
                    }

                    returnData.setUserEmail(resultSet.getString(2));
                    returnData.setDate(null);
                    returnData.setBlood_glucose(blood_glucose);
                    returnData.setHba1c(hba1c);
                    returnData.setHeart_rate(heart_rate);
                    returnData.setBloodpressure_max(bloodpressure_max);
                    returnData.setBloodpressure_min(bloodpressure_min);
                    returnData.setCarbohydrates(carbohydrates);
                    returnData.setSteps(steps);
                    returnData.setSleep(sleep);
                    returnData.setExercise_type(exercise_type);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return returnData;
/*
            HealthData healthData = new HealthData();
            healthData.setUserEmail(resultSet.getString(2));
            healthData.setDate(resultSet.getDate(3));
            healthData.setBlood_glucose(resultSet.getDouble(4));
            healthData.setHba1c(resultSet.getDouble(5));
            healthData.setHeart_rate(resultSet.getInt(6));
            healthData.setBloodpressure_max(resultSet.getInt(7));
            healthData.setBloodpressure_min(resultSet.getInt(8));
            healthData.setCarbohydrates(resultSet.getInt(9));
            healthData.setSteps(resultSet.getInt(10));
            healthData.setSleep(resultSet.getInt(11));
            healthData.setExercise_type(resultSet.getString(12));
            return healthData;*/
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHealthData(HealthData healthData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.healthdata(userEmail, date, blood_glucose, hba1c, heart_rate, bloodpressure_max, bloodpressure_min, carbohydrates, steps, sleep, exercise_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, healthData.getUserEmail());
            preparedStatement.setDate(2, healthData.getDate());
            preparedStatement.setDouble(3, healthData.getBlood_glucose());
            preparedStatement.setDouble(4, healthData.getHba1c());
            preparedStatement.setInt(5, healthData.getHeart_rate());
            preparedStatement.setInt(6, healthData.getBloodpressure_max());
            preparedStatement.setInt(7, healthData.getBloodpressure_min());
            preparedStatement.setInt(8, healthData.getCarbohydrates());
            preparedStatement.setInt(9, healthData.getSteps());
            preparedStatement.setInt(10, healthData.getSleep());
            preparedStatement.setString(11, healthData.getExercise_type());
            int resultSet = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Integer> findUserDataChart(String userEmail) {
        double blood_glucose1 = 0;
        double blood_glucose2 = 0;
        double blood_glucose3 = 0;
        double blood_glucose4 = 0;
        double blood_glucose5 = 0;
        double blood_glucose6 = 0;
        double blood_glucose7 = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT blood_glucose FROM public.healthdata WHERE userEmail= ? order by dataid DESC limit 100");
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            LinkedList returnlist = new LinkedList();

            while (resultSet.next()) {
                try {
                    if (blood_glucose1 == 0) {
                        blood_glucose1 = resultSet.getDouble(1);
                        continue;
                    }
                    if (blood_glucose2 == 0) {
                        blood_glucose2 =  resultSet.getDouble(1);
                        continue;

                    }
                    if (blood_glucose3 == 0) {
                        blood_glucose3 =  resultSet.getDouble(1);
                        continue;

                    }
                    if (blood_glucose4 == 0) {
                        blood_glucose4 =  resultSet.getDouble(1);
                        continue;

                    }
                    if (blood_glucose5 == 0) {
                        blood_glucose5 =  resultSet.getDouble(1);
                        continue;
                    }
                    if (blood_glucose6 == 0) {
                        blood_glucose6 =  resultSet.getDouble(1);
                        continue;
                    }
                    if (blood_glucose7 == 0) {
                        blood_glucose7 =  resultSet.getDouble(1);
                        continue;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            returnlist.add((int)blood_glucose1);
            returnlist.add((int)blood_glucose2);
            returnlist.add((int)blood_glucose3);
            returnlist.add((int)blood_glucose4);
            returnlist.add((int)blood_glucose5);
            returnlist.add((int)blood_glucose6);
            returnlist.add((int)blood_glucose7);
            return returnlist;
        } catch (Exception e){
            e.printStackTrace();
            return null;
            }
            }

    public List<HealthData> findUserCVSData(String userEmail) { // to change
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.healthdata WHERE userEmail= ? order by dataid DESC");
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;

            LinkedList healthDataList = new LinkedList<>();
            while (resultSet.next()) {
                HealthData healthData = new HealthData();
                healthData.setUserEmail(resultSet.getString(2));
                healthData.setDate(resultSet.getDate(3));
                healthData.setBlood_glucose(resultSet.getDouble(4));
                healthData.setHba1c(resultSet.getDouble(5));
                healthData.setHeart_rate(resultSet.getInt(6));
                healthData.setBloodpressure_max(resultSet.getInt(7));
                healthData.setBloodpressure_min(resultSet.getInt(8));
                healthData.setCarbohydrates(resultSet.getInt(9));
                healthData.setSteps(resultSet.getInt(10));
                healthData.setSleep(resultSet.getInt(11));
                healthData.setExercise_type(resultSet.getString(12));
                healthDataList.add(healthData);
            }
            return healthDataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        }
