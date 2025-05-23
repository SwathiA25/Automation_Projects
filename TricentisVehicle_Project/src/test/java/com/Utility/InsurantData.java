package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InsurantData {

		WebDriver driver;
		JavascriptExecutor js;

		public InsurantData(WebDriver driver, JavascriptExecutor js) {
			this.driver = driver;
			this.js = js;
		}
		
		
		public void setFirstName(String fn) {
			driver.findElement(By.id("firstname")).sendKeys(fn);
		}

		public void setLastName(String ln) {
			driver.findElement(By.id("lastname")).sendKeys(ln);
		}

		public void setBirthDate(String bd) {
			driver.findElement(By.id("birthdate")).sendKeys(bd);
		}

		public void selectGender() {
			js.executeScript("arguments[0].click()", driver.findElement(By.id("genderfemale")));
		}
		
		public void setStreetAdd(String st) {
			driver.findElement(By.id("streetaddress")).sendKeys(st);
		}

		public void selectCountry(String cn) {
			new Select(driver.findElement(By.id("country"))).selectByVisibleText(cn);
		}
		
		public void setZipCode(String zp) {
			driver.findElement(By.id("zipcode")).sendKeys(zp);
		}
		
		public void setCity(String ct) {
			driver.findElement(By.id("city")).sendKeys(ct);
		}
		
		public void selectOccupation(String op) {
			new Select(driver.findElement(By.id("occupation"))).selectByVisibleText(op);
		}

		public void selectHobbiesr() {
			js.executeScript("arguments[0].click()", driver.findElement(By.id("other")));
		}
		
		public void nextProductDataBtn() {
			driver.findElement(By.id("nextenterproductdata")).click();
		}
		
		public void filInsurantData() {
			
			setFirstName("Swathi");
			setLastName("Acharya");
			setBirthDate("01/01/1999");
			selectGender();
			setStreetAdd("Hebbal 2nd Stage");
			selectCountry("India");
			setZipCode("570017");
			setCity("Mysore");
			selectOccupation("Unemployed");
			selectHobbiesr();
			nextProductDataBtn();
			
		}

}
