package com.soccer.league.EPL.PageObjectRepository.EPLLeague;

import org.dom4j.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.soccer.league.automation.framework.widgetActions.SeleniumUtils;

public class EPLSoccerPage {
	
	private static By lnkEPLLeauge=By.linkText("/epl/news");
	private static By lnkEPLLeaders=By.linkText("http://www.thescore.com:/epl/leaders");
	private static By lnkEPLLeaders2=By.xpath("/html/body/div[1]/header/div[2]/div/div/nav/a[4]/span/span/span");
	
	public  EPLSoccerPage(){        
	
	}	
		
	public boolean goToEPLPlayers(WebDriver driver)    
	{	   	
	   	//waitForPageLoad(driver);
		
		Assert.assertTrue(SeleniumUtils.click(driver, lnkEPLLeaders2), "Could not click the EPL Leaders Link");				
		return true;  	    
	}	

}
