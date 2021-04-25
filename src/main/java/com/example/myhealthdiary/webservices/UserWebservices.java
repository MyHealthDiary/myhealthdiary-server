package com.example.myhealthdiary.webservices;

import com.example.myhealthdiary.User;
import com.example.myhealthdiary.database.DbConnection;
import com.example.myhealthdiary.database.UserDbData;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
public class UserWebservices {

    private UserDbData userDbData;

    @CrossOrigin
    @PostMapping("/users/login/")
    public User findUserByCredentials(@RequestParam("email") String email,
                                      @RequestParam("password") String password) {
        initDb();
        User user = userDbData.findUserByCredentials(email, password);
        return user;
    }

    @CrossOrigin
    @GetMapping("/users/")
    public User findUserById(@RequestParam("userId") int userId) {
        initDb();
        User user = userDbData.findUserById(userId);
        return user;
    }

    @CrossOrigin
    @PostMapping("/users/findbyemail/")
    public User findUserByEmail(@RequestParam("email") String email) {
        initDb();
        User user = userDbData.findUserByEmail(email);
        return user;
    }

    @CrossOrigin
    @PostMapping("/users/newuser/")
    public User createUser(
            @RequestParam(value = "email", defaultValue = "0") String email,
            @RequestParam(value = "password", defaultValue = "0") String password,
            @RequestParam(value = "firstname", defaultValue = "noname") String firstname,
            @RequestParam(value = "lastname", defaultValue = "") String lastname,
            @RequestParam(value = "birthdate", defaultValue = "") String birthdate,
            @RequestParam(value = "gender", defaultValue = "") String gender,
            @RequestParam(value = "height") int height,
            @RequestParam(value = "weight") double weight,
            @RequestParam(value = "diabet_type", defaultValue = "") String diabet_type) {
        initDb();
        User newUser = new User();
        if (email.equals("0") || password.equals("0")) {
            System.out.println("Missing required parameters");
            return null;
        } else {
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setBirthdate(birthdate);
            newUser.setGender(gender);
            newUser.setHeight(height);
            newUser.setWeight(weight);
            newUser.setDiabet_type(diabet_type);
            userDbData.createUser(newUser);
            return newUser;
        }
    }


    private void initDb() {
        if (userDbData == null) {
            Connection connection = DbConnection.getConnection();
            if (connection == null)
                throw new IllegalStateException();
            userDbData = new UserDbData(connection);
        }
    }

}
