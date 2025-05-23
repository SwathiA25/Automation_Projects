package com.TricentisVehicleProject;

import java.time.Duration;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.Utility.InsurantData;
import com.Utility.ProductData;
import com.Utility.SelectPriceOptions;
import com.Utility.SendQuote;
import com.Utility.VehicleData;

public class AllTests {
	WebDriver driver;
	JavascriptExecutor js;
	VehicleData vd;
	SelectPriceOptions sp;
	InsurantData id;
	SendQuote sq;
	ProductData pd;
	
	@DataProvider
	public Object[][] automobileData() {
		return new Object[][] { 
			new Object[] { "235.00", "No", "No", "No", "Silver" },
			new Object[] { "694.00", "Submit", "2", "Limited", "Gold" },
			new Object[] { "1,362.00", "Submit", "5", "Limited", "Platinum" },
			new Object[] { "2,595.00", "Submit", "10", "Unlimited", "Ultimate" },
		};
	}

	@DataProvider
	public Object[][] truckData() {
		return new Object[][] { 
			new Object[] { "285.00", "No", "No", "No", "Silver" },
			new Object[] { "841.00", "Submit", "2", "Limited", "Gold" },
			new Object[] { "1,651.00", "Submit", "5", "Limited", "Platinum" },
			new Object[] { "3,145.00", "Submit", "10", "Unlimited", "Ultimate" },
		};
	}
	
	@DataProvider
	public Object[][] motorcycleData() {
		return new Object[][] { 
			new Object[] { "238.00", "No", "No", "No", "Silver" },
			new Object[] { "701.00", "Submit", "2", "Limited", "Gold" },
			new Object[] { "1,376.00", "Submit", "5", "Limited", "Platinum" },
			new Object[] { "2,621.00", "Submit", "10", "Unlimited", "Ultimate" },
		};
	}
	
	@DataProvider
	public Object[][] camperData() {
		return new Object[][] { 
			new Object[] { "280.00", "No", "No", "No", "Silver" },
			new Object[] { "825.00", "Submit", "2", "Limited", "Gold" },
			new Object[] { "1,620.00", "Submit", "5", "Limited", "Platinum" },
			new Object[] { "3,086.00", "Submit", "10", "Unlimited", "Ultimate" },
		};
	}
	
	@Test(priority = 1, dataProvider = "automobileData")
	public void automobileTests(String expPrice, String expClaim, String expDis, String expCover, String type) {
		
		driver.findElement(By.id("nav_automobile")).click();

		vd.selectMake("Audi");
		vd.setEnginePerformance("1000");
		vd.setDateOfManif("01/01/2020");
		vd.selectNoOfSeats("4");
		vd.selectFuelType("Petrol");
		vd.setListPrice("1000");
		vd.setLicencePlateNo("KA02SA8956");
		vd.setAnnualMilage("1000");
		vd.nextInsurantDataBtn();
		
		id.filInsurantData();
		
		pd.setStartDate("01/01/2026");
		pd.selectInsSum(" 5.000.000,00");
		pd.selectMeritRating(" Bonus 4");
		pd.selectDamageIns("No Coverage");
		pd.setOptionalProduct();
		pd.selectCourtesyCar("No");
		pd.nextSelectPriceBtn();

		sp.checkOptions(expPrice, expClaim, expDis, expCover, type);
		sp.nextSendQuoteBtn();
		
		sq.fillSendQuote();
		
		driver.findElement(By.id("backmain")).click();

	}
	
	@Test(priority = 2, dataProvider = "truckData")
	public void truckTests(String expPrice, String expClaim, String expDis, String expCover, String type)
	{
		driver.findElement(By.id("nav_truck")).click();
		
		vd.selectMake("Mazda");
		vd.setEnginePerformance("2000");
		vd.setDateOfManif("01/01/2018");
		vd.selectNoOfSeats("2");
		vd.selectFuelType("Diesel");
		vd.setPayLoad("500");
		vd.setTotalWeight("1000");
		vd.setListPrice("1500");
		vd.setLicencePlateNo("KA02SA4452");
		vd.setAnnualMilage("1200");
		vd.nextInsurantDataBtn();
		
		id.filInsurantData();
		
		pd.setStartDate("03/01/2026");
		pd.selectInsSum(" 10.000.000,00");
		pd.selectDamageIns("No Coverage");
		pd.setOptionalProduct();
		pd.nextSelectPriceBtn();
		
		sp.checkOptions(expPrice, expClaim, expDis, expCover, type);
		sp.nextSendQuoteBtn();
		
		sq.fillSendQuote();
		
		driver.findElement(By.id("backmain")).click();
	}

	@Test(priority = 3, dataProvider = "motorcycleData")
	public void motorcycleTests(String expPrice, String expClaim, String expDis, String expCover, String type)
	{
		driver.findElement(By.id("nav_motorcycle")).click();
		
		vd.selectMake("Honda");
		vd.selectModel("Motorcycle");
		vd.selectCyclinderCapacity("500");
		vd.setEnginePerformance("1000");
		vd.setDateOfManif("01/01/2022");
		vd.selectNoOfSeatsOfMotorcycle("2");
		vd.setListPrice("800");
		vd.setAnnualMilage("1000");
		vd.nextInsurantDataBtn();
		
		id.filInsurantData();
		
		pd.setStartDate("01/01/2026");
		pd.selectInsSum(" 3.000.000,00");
		pd.selectDamageIns("No Coverage");
		pd.setOptionalProduct();
		pd.nextSelectPriceBtn();
		
		sp.checkOptions(expPrice, expClaim, expDis, expCover, type);
		sp.nextSendQuoteBtn();
		
		sq.fillSendQuote();
		
		driver.findElement(By.id("backmain")).click();
	}

	@Test(priority = 4, dataProvider = "camperData")
	public void camperTests(String expPrice, String expClaim, String expDis, String expCover, String type)
	{
		driver.findElement(By.id("nav_camper")).click();
		
		vd.selectMake("Renault");
		vd.setEnginePerformance("1300");
		vd.setDateOfManif("01/01/2023");
		vd.selectNoOfSeats("6");
		vd.selectFuelType("Gas");
		vd.selectRHDBtn();
		vd.setPayLoad("1000");
		vd.setTotalWeight("2000");
		vd.setListPrice("1800");
		vd.setLicencePlateNo("KA02SA6254");
		vd.setAnnualMilage("1500");
		vd.nextInsurantDataBtn();
		
		id.filInsurantData();
		
		pd.setStartDate("02/01/2026");
		pd.selectInsSum(" 15.000.000,00");
		pd.selectDamageIns("Full Coverage");
		pd.setOptionalProduct();
		pd.nextSelectPriceBtn();
		
		sp.checkOptions(expPrice, expClaim, expDis, expCover, type);
		sp.nextSendQuoteBtn();
		
		sq.fillSendQuote();
		
		driver.findElement(By.id("backmain")).click();
	}

	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sampleapp.tricentis.com/101/app.php");
		
		js = (JavascriptExecutor) driver;
		
		vd = new VehicleData(driver,js);
		sp = new SelectPriceOptions(driver,js);
		id = new InsurantData(driver,js);
		pd = new ProductData(driver,js);
		sq = new SendQuote(driver,js);
	}

	@AfterTest
	public void tearDown() {
	    driver.quit();
	}
}
