package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductData {

	WebDriver driver;
	JavascriptExecutor js;

	public ProductData(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	
	public void setStartDate(String sd) {
		driver.findElement(By.id("startdate")).sendKeys(sd);
	}

	public void selectInsSum(String sum) {
		new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText(sum);
	}

	public void selectMeritRating(String mr) {
		new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText(mr);
	}

	public void selectDamageIns(String di) {
		new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText(di);
	}
	
	public void setOptionalProduct() {
		js.executeScript("arguments[0].click()", driver.findElement(By.id("EuroProtection")));
	}

	public void selectCourtesyCar(String ccr) {
		new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText(ccr);
	}
	
	public void nextSelectPriceBtn() {
		driver.findElement(By.id("nextselectpriceoption")).click();
	}
	
}
