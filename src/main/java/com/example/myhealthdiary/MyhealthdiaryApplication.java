package com.example.myhealthdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@SpringBootApplication
@RestController
public class MyhealthdiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyhealthdiaryApplication.class, args);
	}
}