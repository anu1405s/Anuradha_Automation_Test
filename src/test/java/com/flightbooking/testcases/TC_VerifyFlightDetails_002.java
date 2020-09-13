package com.flightbooking.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flightbooking.pageobjects.FlightRegistration;
import com.flightbooking.pageobjects.SelectFlightPage;
import com.flightbooking.pageobjects.WelcomePage;

public class TC_VerifyFlightDetails_002 extends Base {
	
	@Test
	public void verifyFlightDetails() throws Exception
	{
		WelcomePage wp = new WelcomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("BlazeDemo"));
		if (driver.getTitle().equals("BlazeDemo")) {
			System.out.println("Title Verified");
			Assert.assertTrue(true);
		} else {
			System.out.println("Title not Verified");
			Assert.assertTrue(false);
		}
		wp.setDepartureCity("Paris");
		wp.setDestinationCity("London");
		wp.clickFindFlights();
		
		wait.until(ExpectedConditions.titleContains("BlazeDemo - reserve"));
		if (driver.getTitle().equals("BlazeDemo - reserve")) {
			System.out.println("FindFlights clicked and redirected");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		SelectFlightPage sf = new SelectFlightPage(driver);
		sf.selectFlight();
		
		wait.until(ExpectedConditions.titleContains("BlazeDemo Purchase"));

		FlightRegistration fr = new FlightRegistration(driver);
		String flightDetails = fr.getFlightDetails();
		if (flightDetails.contains("Your flight from TLV to SFO has been reserved.")) {
			System.out.println("reserved");
			Assert.assertTrue(true);
		} else {
			System.out.println("Not reserved");
			Assert.assertTrue(false);
		}

		String aireLineName = fr.getAirlineName();
		if (aireLineName.contains("United")) {
			System.out.println("Airline name verified");
			Assert.assertTrue(true);
		} else {
			System.out.println("Airline name not verified");
			Assert.assertTrue(false);
		}
		String flightNumber = fr.getFlightNumber();
		if (flightNumber.contains("UA954")) {
			System.out.println("Flight Number verified");
			Assert.assertTrue(true);
		} else {
			System.out.println("Flight Number not verified");
			Assert.assertTrue(false);
		}
		String flightCost = fr.getFlightCost();
		if (flightCost.contains("Total Cost: 914.76")) {
			System.out.println("Total Cost verified");
			Assert.assertTrue(true);
		} else {
			System.out.println("Total Cost not verified");
			Assert.assertTrue(false);
		}
		
	}
	
	

}
