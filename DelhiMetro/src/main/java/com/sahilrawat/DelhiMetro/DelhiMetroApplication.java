package com.sahilrawat.DelhiMetro;

import com.sahilrawat.DelhiMetro.service.GetAllStations;
import net.bytebuddy.description.type.TypeList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DelhiMetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelhiMetroApplication.class, args);
	}
}
