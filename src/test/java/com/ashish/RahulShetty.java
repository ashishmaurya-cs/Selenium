package com.ashish;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RahulShetty {
	
	  // Create a logger instance
    private static final Logger logger = LogManager.getLogger(RahulShetty.class);
	@Test
	public void setUp(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		logger.info("Browser launched...");
		driver.manage().window().maximize();
	}
}
