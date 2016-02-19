package com.soccer.league.EPL.PageObjectRepository.EPLLeague;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.soccer.league.automation.framework.widgetActions.SeleniumUtils;

public class EPLSoccerPage  extends SeleniumUtils {
	
	private static By lnkEPLLeaders=By.xpath("/html/body/div[1]/header/div[2]/div/div/nav/a[4]/span/span/span");
	
	public  EPLSoccerPage(){        
	
	}	
		
	public boolean goToEPLPlayers(WebDriver driver)    
	{	   	
	   	waitForPageLoad(driver);		
		Assert.assertTrue(SeleniumUtils.click(driver, lnkEPLLeaders), "Could not click the EPL Leaders Link");				
		return true;  	    
	}	

}
