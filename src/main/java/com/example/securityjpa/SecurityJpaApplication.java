package com.example.securityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SecurityJpaApplication {
//
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SecurityJpaApplication.class, args);
        openHomePage();
    }

    private static void openHomePage() throws IOException {
        String url = "http://localhost:8080/hello";
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
}
