package com.flightbooking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightRegistration {
	
	WebDriver ldriver;
	public FlightRegistration(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath="//html/body/div[@class='container']/h2")
	WebElement getFlightHeading;
	
	@FindBy(xpath="//html/body/div[@class='container']/p[1]")
	WebElement getAirlineName;
	
	@FindBy(xpath="//html/body/div[@class='container']/p[2]")
	WebElement getFlightNumber;
	
	@FindBy(xpath="//html/body/div[@class='container']/p[5]")
	WebElement getFlightCost;
	
	@FindBy(id="inputName")
	WebElement setName;
	
	@FindBy(id="address")
	WebElement setAddress;
	
	@FindBy(id="city")
	WebElement setCity;
	
	@FindBy(id="state")
	WebElement setState;
	
	@FindBy(id="zipCode")
	WebElement setZipCode;
	
	@FindBy(id="cardType")
	WebElement setCardType;
	
	@FindBy(id="creditCardNumber")
	WebElement setCardNumber;
	
	@FindBy(id="creditCardMonth")
	WebElement setCardMonth;
	
	@FindBy(id="creditCardYear")
	WebElement setCardYear;
	
	@FindBy(id="nameOnCard")
	WebElement setCardName;
	
	@FindBy(id="rememberMe")
	WebElement clickRemeberMe;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement purchaseFlight;
	
	public String getFlightDetails()
	{
		String flightDetails=getFlightHeading.getText();
		return flightDetails;
	}
	
	public String getAirlineName()
	{
		String flightName=getAirlineName.getText();
		return flightName;
	}
	
	public String getFlightNumber()
	{
		String flightNumber=getFlightNumber.getText();
		return flightNumber;
	}
	
	public String getFlightCost()
	{
		String flightCost=getFlightCost.getText();
		return flightCost;
	}
	
	public void enterName(String name)
	{
		setName.sendKeys(name);
		
	}
	
	public void enterAddress(String address)
	{
		setAddress.sendKeys(address);
		
	}
	
	public void enterCity(String city)
	{
		setCity.sendKeys(city);
		
	}
	public void enterState(String state)
	{
		setState.sendKeys(state);
		
	}
	public void enterZipCode(String zipcode)
	{
		setZipCode.sendKeys(zipcode);
		
	}
	public void selectCardType(String cardType)
	{
		Select select=new Select(setCardType);
		select.selectByVisibleText(cardType);
		
	}
	public void enterCardNumber(String cardNumber)
	{
		setCardNumber.sendKeys(cardNumber);
		
	}
	
	public void enterCardMonth(String cardMonth)
	{
		setCardMonth.sendKeys(cardMonth);
		
	}
	
	public void enterCardYear(String cardYear)
	{
		setCardYear.sendKeys(cardYear);
		
	}
	
	public void enterCardName(String cardName)
	{
		setCardName.sendKeys(cardName);
		
	}
	
	public void clickRemberMe()
	{
		clickRemeberMe.click();
		
	}
	
	public void clickPurchaseFlight()
	{
		purchaseFlight.click();
		
	}

}
