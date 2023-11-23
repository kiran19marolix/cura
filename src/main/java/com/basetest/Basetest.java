package com.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basetest {
	public static Properties prop;
	FileInputStream file;
	public static WebDriver driver;

	public Basetest() {
		
       try {
			file = new FileInputStream("./src/main/java/com/configprop/credentials");
		   } catch (FileNotFoundException e) {
			e.printStackTrace();
		   }

		   prop = new Properties();

		try {
			prop.load(file);
		   } catch (IOException e) {
			e.printStackTrace();
		   }	  

	}

	public void initialization() {
		

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("firefox")) {

			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();

	}
}
