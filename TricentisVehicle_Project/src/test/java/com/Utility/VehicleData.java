package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VehicleData {

	WebDriver driver;
	JavascriptExecutor js;

	public VehicleData(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public void selectMake(String make) {
		new Select(driver.findElement(By.id("make"))).selectByVisibleText(make);
	}

	public void setEnginePerformance(String ep) {
		driver.findElement(By.id("engineperformance")).sendKeys(ep);
	}

	public void setDateOfManif(String dt) {
		driver.findElement(By.id("dateofmanufacture")).sendKeys(dt);
	}

	public void selectNoOfSeats(String seats) {
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(seats);
	}

	public void selectNoOfSeatsOfMotorcycle(String seatsOfM) {
		new Select(driver.findElement(By.id("numberofseatsmotorcycle"))).selectByVisibleText(seatsOfM);
	}
	
	public void selectModel(String model) {
		new Select(driver.findElement(By.id("model"))).selectByVisibleText(model);
	}
	
	public void selectCyclinderCapacity(String cc) {
		driver.findElement(By.id("cylindercapacity")).sendKeys(cc);
	}
	
	public void selectFuelType(String type) {
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText(type);
	}

	public void setListPrice(String price) {
		driver.findElement(By.id("listprice")).sendKeys(price);
	}

	public void setLicencePlateNo(String no) {
		driver.findElement(By.id("licenseplatenumber")).sendKeys(no);
	}

	public void setAnnualMilage(String milage) {
		driver.findElement(By.id("annualmileage")).sendKeys(milage);
	}

	public void nextInsurantDataBtn() {
		driver.findElement(By.id("nextenterinsurantdata")).click();
	}

	public void selectRHDBtn() {
		js.executeScript("arguments[0].click()", driver.findElement(By.id("righthanddriveyes")));
	}
	
	public void setPayLoad(String load) {
		driver.findElement(By.id("payload")).sendKeys(load);
	}

	public void setTotalWeight(String weight) {
		driver.findElement(By.id("totalweight")).sendKeys(weight);
	}
}