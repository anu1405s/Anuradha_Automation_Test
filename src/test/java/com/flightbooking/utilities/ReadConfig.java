package com.flightbooking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);			
		}
		catch (Exception e) {
			System.out.println("Exception "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String appURL=pro.getProperty("baseURL");
		return appURL;
	}
	
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getGeckoPath()
	{
		String geckoPath=pro.getProperty("geckoPath");
		return geckoPath;
	}
	
	public String getIEPath()
	{
		String iePath=pro.getProperty("iePath");
		return iePath;
	}

}
