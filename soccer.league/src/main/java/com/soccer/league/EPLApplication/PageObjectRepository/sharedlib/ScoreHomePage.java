package com.soccer.league.EPLApplication.PageObjectRepository.sharedlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.soccer.league.automation.framework.widgetActions.SeleniumUtils;


public class ScoreHomePage extends SeleniumUtils{
	
	
	private static By btnMainMenu=By.xpath("/html/body/div[1]/header/div[1]/div/div/div[1]/div/button");
	private static By lnkEPLLeague=By.xpath("//div[5]/a/span");
	private static By lnkScoreLogo=By.cssSelector("div.thescore-logo");
	public static WebDriver driver;
	
	
	// verify that the correct URL loads-- correct Score Logo shows up 
	public  ScoreHomePage(){        
		
	   	SeleniumUtils.isElementPresent(driver, lnkScoreLogo);
	}		
	
	
	// Navigate to MainMenu-> Trending->EPL Soccer
	
	public boolean goToMainMenuTrendingEPLSoccer(WebDriver driver)
       
	{	   	
	   	waitForPageLoad(driver);
	   	waitForPageLoad(driver);
		Assert.assertTrue(SeleniumUtils.click(driver, btnMainMenu), "Could not click the Main Menu");
		waitForPageLoad(driver);
		Assert.assertTrue(SeleniumUtils.click(driver, lnkEPLLeague), "Could not click EPLLeague link");
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;  	    
	}
	

}
