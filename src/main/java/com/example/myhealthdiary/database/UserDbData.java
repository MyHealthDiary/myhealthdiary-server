package com.example.myhealthdiary.database;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.myhealthdiary.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UserDbData {
    private final Connection connection;
    private static final SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public UserDbData(Connection connection) {
        this.connection = connection;
    }

    public User findUserByCredentials(String email, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user WHERE email= ? AND password= ? ;");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            User user = new User();
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirstname(resultSet.getString(4));
            user.setLastname(resultSet.getString(5));
            user.setBirthdate(resultSet.getString(6));
            user.setGender(resultSet.getString(7));
            user.setHeight(resultSet.getInt(8));
            user.setWeight(resultSet.getDouble(9));
            user.setDiabet_type(resultSet.getString(10));
            user.setGlucoseRangeMax(resultSet.getInt(11));
            user.setGlucoseRangeMin(resultSet.getInt(12));
            user.setPressureRangeMax(resultSet.getInt(13));
            user.setGlucoseRangeMin(resultSet.getInt(14));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findUserById(int userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user WHERE userid= ?;");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            User user = new User();
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirstname(resultSet.getString(4));
            user.setLastname(resultSet.getString(5));
            user.setBirthdate(resultSet.getString(6));
            user.setGender(resultSet.getString(7));
            user.setHeight(resultSet.getInt(8));
            user.setWeight(resultSet.getDouble(9));
            user.setDiabet_type(resultSet.getString(10));
            user.setGlucoseRangeMax(resultSet.getInt(11));
            user.setGlucoseRangeMin(resultSet.getInt(12));
            user.setPressureRangeMax(resultSet.getInt(13));
            user.setGlucoseRangeMin(resultSet.getInt(14));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createUser(User newUser) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.user(email, password, firstname, lastname, birthdate, gender, height, weight, diabet_type, glucoseRangeMax, glucoseRangeMin, pressureRangeMax, pressureRangeMin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, newUser.getEmail());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setString(3, newUser.getFirstname());
            preparedStatement.setString(4, newUser.getLastname());
            preparedStatement.setString(5, newUser.getBirthdate());
            preparedStatement.setString(6, newUser.getGender());
            preparedStatement.setInt(7, newUser.getHeight());
            preparedStatement.setDouble(8, newUser.getWeight());
            preparedStatement.setString(9, newUser.getDiabet_type());
            preparedStatement.setInt(10, newUser.getGlucoseRangeMax());
            preparedStatement.setInt(11, newUser.getGlucoseRangeMin());
            preparedStatement.setInt(12, newUser.getPressureRangeMax());
            preparedStatement.setInt(13, newUser.getPressureRangeMin());
            int resultSet = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findUserByEmail(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.user WHERE email= ?;");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            User user = new User();
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirstname(resultSet.getString(4));
            user.setLastname(resultSet.getString(5));
            user.setBirthdate(resultSet.getString(6));
            user.setGender(resultSet.getString(7));
            user.setHeight(resultSet.getInt(8));
            user.setWeight(resultSet.getDouble(9));
            user.setDiabet_type(resultSet.getString(10));
            user.setGlucoseRangeMax(resultSet.getInt(11));
            user.setGlucoseRangeMin(resultSet.getInt(12));
            user.setPressureRangeMax(resultSet.getInt(13));
            user.setGlucoseRangeMin(resultSet.getInt(14));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
