package com.Gladys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSauceDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Test Case 1: Login Successfully
		
		// Open the website
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\dell\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		// Wait
		WebDriverWait waitLogin = new WebDriverWait(driver, 10);
		waitLogin.until(
			ExpectedConditions.visibilityOfElementLocated(By.className("login_logo"))
		);
		
		// Input username -> xpath locator
		WebElement inputUsername = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		inputUsername.sendKeys("standard_user");
		
		// Input password -> xpath locator
		WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		inputPassword.sendKeys("secret_sauce");
		
		// Login button -> ID locator
		driver.findElement(By.id("login-button")).click();
		
		// Wait
		WebDriverWait waitPage = new WebDriverWait(driver, 10);
		waitPage.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))
		);
		
		// Quit 
		Thread.sleep(2000);
		driver.quit();
		
	}

}
