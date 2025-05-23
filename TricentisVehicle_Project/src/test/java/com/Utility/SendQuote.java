package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SendQuote {
	
	WebDriver driver;
	JavascriptExecutor js;

	public SendQuote(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	public void setEmail(String em) {
		driver.findElement(By.id("email")).sendKeys(em);
	}

	public void setPhone(String ph) {
		driver.findElement(By.id("phone")).sendKeys(ph);
	}

	public void setUsername(String un) {
		driver.findElement(By.id("username")).sendKeys(un);
	}
	
	public void setPassword(String ps) {
		driver.findElement(By.id("password")).sendKeys(ps);
	}
	
	public void setConfirmPass(String cps) {
		driver.findElement(By.id("confirmpassword")).sendKeys(cps);
	}
	
	public void setCity(String ct) {
		driver.findElement(By.id("city")).sendKeys(ct);
	}
	
	public void setComments(String cm) {
		driver.findElement(By.id("Comments")).sendKeys(cm);
	}

	public void clickSendEmail() {
		js.executeScript("arguments[0].click()", driver.findElement(By.id("sendemail")));
	}
	
	public void checkConfirmationMsg() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = driver.findElement(By.xpath("//h2[normalize-space()='Sending e-mail success!']")).getText();
		Assert.assertEquals(msg, "Sending e-mail success!");
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
	}
	
	public void fillSendQuote() {
		
		setEmail("swathi@gmail.com");
		setPhone("8645237895");
		setUsername("Swathi");
		setPassword("Swathi@123");
		setConfirmPass("Swathi@123");
		setComments("No comment");
		clickSendEmail();
		checkConfirmationMsg();
		
	}

}
