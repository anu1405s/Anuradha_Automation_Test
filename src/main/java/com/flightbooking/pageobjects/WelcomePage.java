package com.flightbooking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
	
	WebDriver ldriver;
	
	public WelcomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(name="fromPort")
	WebElement departureCity;
	
	@FindBy(name="toPort")
	WebElement destinationCity;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement findFlights;
	
	
	public void setDepartureCity(String depatureCityName)
	{
		Select select=new Select(departureCity);
		select.selectByVisibleText(depatureCityName);
	}
	
	public void setDestinationCity(String destinationCityName)
	{
		Select select=new Select(destinationCity);
		select.selectByVisibleText(destinationCityName);
	}
	
	public void clickFindFlights()
	{
		findFlights.click();
		
	}
	

}
