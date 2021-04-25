package com.example.myhealthdiary.webservices;

import com.example.myhealthdiary.HealthData;
import com.example.myhealthdiary.User;
import com.example.myhealthdiary.database.ChartData;
import com.example.myhealthdiary.database.DbConnection;
import com.example.myhealthdiary.database.HealthDataDbData;
import com.example.myhealthdiary.database.UserDbData;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@RestController
public class HealthdataWebservices {

    private HealthDataDbData healthDataDbData;
    private UserDbData userDbData;

    @CrossOrigin
    @PostMapping("/databyuser/")
    public HealthData findHealthDataByUser(
            @RequestParam(value = "userEmail") String userEmail) {
        initDb();
        HealthData healthData = healthDataDbData.findHealthDataByUser(userEmail);
        return healthData;
    }

    @CrossOrigin
    @PostMapping("/databyday/")
    public List<HealthData> findUserDataByDay(
            @RequestParam("userid") int userid,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year) {
        initDb();
        return healthDataDbData.findUserDataByDay(userid, day, month, year);
    }

    @CrossOrigin
    @PostMapping("/datachart/")
    public ChartData findDataChart(
            @RequestParam("userEmail") String userEmail) {
        initDb();
        List<Integer> datalist = healthDataDbData.findUserDataChart(userEmail);
        System.out.printf(datalist.toString());
        int entry1 = datalist.get(0);
        int entry2 = datalist.get(1);
        int entry3 = datalist.get(2);
        int entry4 = datalist.get(3);
        int entry5 = datalist.get(4);
        int entry6 = datalist.get(5);
        int entry7 = datalist.get(6);
        System.out.println(entry1);

        ChartData returnData = new ChartData();
        returnData.setEntry1(entry1);
        returnData.setEntry2(entry2);
        returnData.setEntry3(entry3);
        returnData.setEntry4(entry4);
        returnData.setEntry5(entry5);
        returnData.setEntry6(entry6);
        returnData.setEntry7(entry7);

        return returnData;
    }


    @CrossOrigin
    @PostMapping("/adddata/")
    public HealthData addHealthData(
            @RequestParam(value = "userEmail") String userEmail,
            @RequestParam(value = "blood_glucose", defaultValue = "0") double blood_glucose,
            @RequestParam(value = "hba1c", defaultValue = "0") double hba1c,
            @RequestParam(value = "heart_rate", defaultValue = "0") int heart_rate,
            @RequestParam(value = "bloodpressure_max", defaultValue = "0") int bloodpressure_max,
            @RequestParam(value = "bloodpressure_min", defaultValue = "0") int bloodpressure_min,
            @RequestParam(value = "carbohydrates", defaultValue = "0") int carbohydrates,
            @RequestParam(value = "steps", defaultValue = "0") int steps,
            @RequestParam(value = "sleep", defaultValue = "0") int sleep,
            @RequestParam(value = "exercise_type", defaultValue = " ") String exercise_type) {

        initDb();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = new Date(System.currentTimeMillis());
        String dateString = format.format(date2);
        HealthData healthData = new HealthData();

        healthData.setUserEmail(userEmail);
        healthData.setDate(java.sql.Date.valueOf(dateString));
        healthData.setBlood_glucose(blood_glucose);
        healthData.setHba1c(hba1c);
        healthData.setHeart_rate(heart_rate);
        healthData.setBloodpressure_max(bloodpressure_max);
        healthData.setBloodpressure_min(bloodpressure_min);
        healthData.setCarbohydrates(carbohydrates);
        healthData.setSteps(steps);
        healthData.setSleep(sleep);
        healthData.setExercise_type(exercise_type);
        healthDataDbData.addHealthData(healthData);
        return healthData;
    }

    @CrossOrigin
    @PostMapping("/buildcvsall/")
    public List<HealthData> buildAllTimeCVS(
            @RequestParam("userEmail")  String userEmail) {
        initDb();
        return healthDataDbData.findUserCVSData(userEmail);
    }

    @CrossOrigin
    @PostMapping("/builcvslastmonth/")
    public List<HealthData> buildLastMonthCVS(
            @RequestParam("userid") int userid,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year) {
        initDb();
        return healthDataDbData.findUserDataByDay(userid, day, month, year);
    }

    @CrossOrigin
    @PostMapping("/builcvsthismonth/")
    public List<HealthData> buildThisMonthCVS(
            @RequestParam("userid") int userid,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year) {
        initDb();
        return healthDataDbData.findUserDataByDay(userid, day, month, year);
    }


    private void initDb() {
        if (healthDataDbData == null) {
            Connection connection = DbConnection.getConnection();
            if (connection == null)
                throw new IllegalStateException();
            healthDataDbData = new HealthDataDbData(connection);
        }
    }

}
