package com.flightbooking.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flightbooking.pageobjects.FlightRegistration;
import com.flightbooking.pageobjects.InvoicePage;
import com.flightbooking.pageobjects.SelectFlightPage;
import com.flightbooking.pageobjects.WelcomePage;

public class TC_BookFlight_001 extends Base {
	

	@Test
	public void bookFlight() throws Exception {
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
		fr.enterName("ABCD");
		fr.enterAddress("Street-47");
		fr.enterCity("NY");
		fr.enterState("NY,US");
		fr.enterZipCode("1234");
		fr.selectCardType("Visa");
		fr.enterCardNumber("123456789");
		fr.enterCardMonth("09");
		fr.enterCardYear("2020");
		fr.enterCardName("ABCD");
		fr.clickRemberMe();
		fr.clickPurchaseFlight();
		
		InvoicePage ip = new InvoicePage(driver);
		wait.until(ExpectedConditions.titleContains("BlazeDemo Confirmation"));
		String confirmationMessage = ip.getConfirmationMessage();
		if (confirmationMessage.contains("Thank you for your purchase today!")) {
			System.out.println("Confirmation message verified");
			Assert.assertTrue(true);
		} else {
			System.out.println("Confirmation message not verified");
			Assert.assertTrue(false);
		}

		String confirmationId = ip.getConfirmationID();
		System.out.println("confirmationId: "+confirmationId);
		if (!confirmationId.equals(null)) {
			System.out.println("Confirmation id verified");
			Assert.assertTrue(true);

			
		} else {
			System.out.println("Confirmation id not verified");
			Assert.assertTrue(false);
		}
	}

}
