package com.flightbooking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	
	WebDriver ldriver;
	public InvoicePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='container hero-unit']/h1")
	WebElement getConfirmationMessage;
	
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td[2]")
	WebElement getConfirmationID;
	
	public String getConfirmationMessage()
	{
		String confirmationMessage=getConfirmationMessage.getText();
		return confirmationMessage;
	}
	
	public String getConfirmationID()
	{
		String confirmationID=getConfirmationID.getText();
		return confirmationID;
	}
	

}
