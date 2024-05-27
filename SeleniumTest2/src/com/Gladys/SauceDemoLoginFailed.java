package com.Gladys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoLoginFailed {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Test Case 2: Failed to Login
		
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
		inputUsername.sendKeys("abcde");
				
		// Input password -> xpath locator
		WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		inputPassword.sendKeys("secret_sauce");
				
		// Login button -> ID locator
		driver.findElement(By.id("login-button")).click();
				
		// Wait
		WebDriverWait waitError = new WebDriverWait(driver, 10);
		waitError.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
		);
				
		// Write The Error
		String errorLoginMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		System.out.println("Error Message: " + errorLoginMsg);
		
		// Quit 
		Thread.sleep(2000);
		driver.quit();
	}

}
