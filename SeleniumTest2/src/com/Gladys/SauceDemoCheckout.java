package com.Gladys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoCheckout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Test Case 3: Product Checkout
		
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
		
		// Click Product
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
				
		// Click Shopping Cart
		driver.findElement(By.className("shopping_cart_link")).click();
		
		// Wait for 1 Second
		Thread.sleep(1000);
				
		// Click Checkout button
		driver.findElement(By.id("checkout")).click();
		
		// Input form
		// a. First name
		driver.findElement(By.id("first-name")).sendKeys("Gladys");
		// b. Last name
		driver.findElement(By.id("last-name")).sendKeys("Tanujaya");
		// c. Postal code
		driver.findElement(By.id("postal-code")).sendKeys("10460");
		
		// Wait for 2 Seconds
		Thread.sleep(2000);
		
		// Scroll down
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scroll(0, 300)");
		
		// Click Checkout button
		driver.findElement(By.id("continue")).click();
		
		// Wait for 2 Seconds 
		Thread.sleep(2000);
		
		// Scroll down
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scroll(0, 300)");
		
		// Click Finish button
		driver.findElement(By.id("finish")).click();
		
		// Wait for 2 Seconds 
		Thread.sleep(1000);
		
		// Quit 
		driver.quit();
	}

}
