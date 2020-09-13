package com.flightbooking.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {
	
	WebDriver ldriver;
	public SelectFlightPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath="//table[@class='table']/tbody/tr")
	List <WebElement> flightRowCount;
	
	@FindBy(xpath="//table[@class='table']/tbody/tr[1]/td")
	List <WebElement> flightColCount;
	
	@FindBy(xpath="//td[text()='United Airlines']//preceding-sibling::td/input[@class='btn btn-small']")
	WebElement selectFlight;
	
	
	public int getRowCount()
	{
		int rowCount=flightRowCount.size();
		return rowCount;
	}
	
	public int getColCount()
	{
		int colCount=flightRowCount.size();
		return colCount;
	}
	
	public void selectFlight()
	{
		selectFlight.click();
		
	}
	
	
	

}
