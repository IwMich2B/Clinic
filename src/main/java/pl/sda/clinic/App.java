package pl.sda.clinic;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication

@ComponentScan("pl.sda.clinic")

public class App {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(App.class);
//        Properties properties = new Properties();
//        properties.put("SERVER_PORT", 9999);
//        springApplication.setDefaultProperties(properties);
//        springApplication.run(args);
        SpringApplication.run(App.class,args);
    }
}