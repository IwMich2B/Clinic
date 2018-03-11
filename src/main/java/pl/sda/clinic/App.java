package pl.sda.clinic;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("pl.sda.clinic")

public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);



    }

    }


