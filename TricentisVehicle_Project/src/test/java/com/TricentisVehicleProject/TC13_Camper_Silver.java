package com.TricentisVehicleProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC13_Camper_Silver {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sampleapp.tricentis.com/101/index.php");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot rbt = new Robot();
		
		//Click on Truck
		driver.findElement(By.id("nav_camper")).click();
		
		//Enter vehicle data
		new Select(driver.findElement(By.id("make"))).selectByVisibleText("Renault");
		driver.findElement(By.id("engineperformance")).sendKeys("1300");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("01/01/2023");
		new Select(driver.findElement(By.id("numberofseats"))).selectByValue("6");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("righthanddriveyes")));
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Gas");
		driver.findElement(By.id("payload")).sendKeys("1000");
		driver.findElement(By.id("totalweight")).sendKeys("2000");
		driver.findElement(By.id("listprice")).sendKeys("1800");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("KA02SA6254");
		driver.findElement(By.id("annualmileage")).sendKeys("1500");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant data
		driver.findElement(By.id("firstname")).sendKeys("Swathi");
		driver.findElement(By.id("lastname")).sendKeys("Acharya");
		driver.findElement(By.id("birthdate")).sendKeys("03/25/1997");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("genderfemale")));
		driver.findElement(By.id("streetaddress")).sendKeys("Hebbal 2nd Stage");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
		driver.findElement(By.id("zipcode")).sendKeys("570017");
		driver.findElement(By.id("city")).sendKeys("Mysore");
		new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Unemployed");
		js.executeScript("arguments[0].click()",driver.findElement(By.id("cliffdiving")));
		driver.findElement(By.id("open")).click();
		
		for(int i = 1; i <= 8; i++)
		{
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_TAB);
		}
		for(int j = 1; j <= 4; j++)
		{
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN);
		}
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.id("nextenterproductdata")).click();
		
		//Enter Product data
		driver.findElement(By.id("startdate")).sendKeys("02/01/2026");
		new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText(" 15.000.000,00");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("Full Coverage");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("EuroProtection")));
		
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		//Select Price option
		String expPrice = "280.00", expClaim = "No", expDis = "No", expCov = "No", actPrice, actClaim, actDis, actCov;
		
		actPrice = driver.findElement(By.id("selectsilver_price")).getText();
		actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[2]")).getText();
		actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[2]")).getText();
		actCov = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[2]")).getText();
		
		System.out.println("Checking Camper - Silver Values");
		if(actPrice.equals(expPrice))
			System.out.println("Price Matching");
		else
			System.out.println("Price Not Matching");
		
		if(actClaim.equals(expClaim))
			System.out.println("Claim Matching");
		else
			System.out.println("Claim Not Matching");
		
		if(actDis.equals(expDis))
			System.out.println("Discount Matching");
		else
			System.out.println("Discount Not Matching");
		
		if(actCov.equals(expCov))
			System.out.println("Cover Matching");
		else
			System.out.println("Cover Not Matching");
		
		js.executeScript("arguments[0].click()", driver.findElement(By.id("selectsilver")));
		
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quote
		driver.findElement(By.id("email")).sendKeys("swathi@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("8645237895");
		driver.findElement(By.id("username")).sendKeys("Swathi");
		driver.findElement(By.id("password")).sendKeys("Swathi@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Swathi@123");
		driver.findElement(By.id("Comments")).sendKeys("No comment");
		driver.findElement(By.id("sendemail")).click();
		
		System.out.println("\nMessage: "+driver.findElement(By.xpath("//h2[normalize-space()='Sending e-mail success!']")).getText());
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		
		driver.findElement(By.id("backmain")).click();
		
		driver.close();
	}

}
