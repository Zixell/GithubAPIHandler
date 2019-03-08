package com.zixel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zixel.dao.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(Application.class, args);
  }

}