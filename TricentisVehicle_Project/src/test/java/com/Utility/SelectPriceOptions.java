package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SelectPriceOptions {

	WebDriver driver;
	JavascriptExecutor js;

	public SelectPriceOptions(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	public void nextSendQuoteBtn() {
		driver.findElement(By.id("nextsendquote")).click();
	}

	public void checkOptions(String expPrice, String expClaim, String expDis, String expCover, String type) {
		
		String actPrice, actClaim, actDis, actCover;

		switch (type) {
		case "Silver":
			actPrice = driver.findElement(By.xpath("//span[@id='selectsilver_price']")).getText();
			actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[2]")).getText();
			actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[2]")).getText();
			actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[2]")).getText();
			
			if (expPrice.equals(actPrice))
				System.out.println("Price Matching");
			else
				System.out.println("Price Not Matching");
			
			if (expClaim.equals(actClaim))
				System.out.println("Claim Matching");
			else
				System.out.println("Claim Not Matching");

			if (expDis.equals(actDis))
				System.out.println("Discount Matching");
			else
				System.out.println("Discount Not Matching");

			if (expCover.equals(actCover))
				System.out.println("Cover Matching");
			else
				System.out.println("Cover Not Matching");
			
			js.executeScript("arguments[0].click()", driver.findElement(By.id("selectsilver")));

			break;

		case "Gold":
			actPrice = driver.findElement(By.xpath("//span[@id='selectgold_price']")).getText();
			actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[3]")).getText();
			actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[3]")).getText();
			actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[3]")).getText();

			if (expPrice.equals(actPrice))
				System.out.println("Price Matching");
			else
				System.out.println("Price Not Matching");
			
			if (expClaim.equals(actClaim))
				System.out.println("Claim Matching");
			else
				System.out.println("Claim Not Matching");

			if (expDis.equals(actDis))
				System.out.println("Discount Matching");
			else
				System.out.println("Discount Not Matching");

			if (expCover.equals(actCover))
				System.out.println("Cover Matching");
			else
				System.out.println("Cover Not Matching");
			
			js.executeScript("arguments[0].click()", driver.findElement(By.id("selectgold")));

			break;
			
		case "Platinum":
			actPrice = driver.findElement(By.id("selectplatinum_price")).getText();
			actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]")).getText();
			actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]")).getText();
			actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]")).getText();

			if (expPrice.equals(actPrice))
				System.out.println("Price Matching");
			else
				System.out.println("Price Not Matching");

			if (expClaim.equals(actClaim))
				System.out.println("Claim Matching");
			else
				System.out.println("Claim Not Matching");

			if (expDis.equals(actDis))
				System.out.println("Discount Matching");
			else
				System.out.println("Discount Not Matching");

			if (expCover.equals(actCover))
				System.out.println("Cover Matching");
			else
				System.out.println("Cover Not Matching");
			
			
			js.executeScript("arguments[0].click()", driver.findElement(By.id("selectplatinum")));

			break;
			
		case "Ultimate":
			actPrice = driver.findElement(By.id("selectultimate_price")).getText();
			actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[5]")).getText();
			actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[5]")).getText();
			actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[5]")).getText();
			
			if (expPrice.equals(actPrice))
				System.out.println("Price Matching");
			else
				System.out.println("Price Not Matching");

			if (expClaim.equals(actClaim))
				System.out.println("Claim Matching");
			else
				System.out.println("Claim Not Matching");

			if (expDis.equals(actDis))
				System.out.println("Discount Matching");
			else
				System.out.println("Discount Not Matching");

			if (expCover.equals(actCover))
				System.out.println("Cover Matching");
			else
				System.out.println("Cover Not Matching");
			
			js.executeScript("arguments[0].click()", driver.findElement(By.id("selectultimate")));

			break;	
			
		default:
			System.out.println("Type mismatch");
			break;
		}

	}

}
