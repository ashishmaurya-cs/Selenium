package com.ashish;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalenderAutomation {

	WebDriver driver;

	String url = "https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html";

	@BeforeTest
	public void launchApplication() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	@Parameters({ "day", "month", "year" })
	public void selectDate(String expDay, String expMonth, String expYear) {
		driver.findElement(By.id("datepicker")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ui-datepicker-calendar"))));
		
		String[] monthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
		
		
		while (!(monthYear[0].equals(expMonth) && monthYear[1].equals(expYear))) {
			System.out.println(Arrays.toString(monthYear));
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
			
		}
		
		System.out.println(Arrays.toString(monthYear));
		driver.findElement(By.xpath("//a[text()="+expDay+"]")).click();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
