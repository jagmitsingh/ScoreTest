package com.soccer.league.EPL.PageObjectRepository.EPLLeague;

import org.dom4j.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.soccer.league.automation.framework.frameworkUtils.XMLParser.DomParser;
import com.soccer.league.automation.framework.widgetActions.SeleniumUtils;

public class EPLSoccerPlayersPage extends SeleniumUtils{
	
	private static By lnkPlayerVardy=By.linkText("/epl/players/16498");
	private static By lnkPlayerVardy2=By.xpath("/html/body/div[3]/div/div/div[2]/div/section/div/div[1]/ul/li[1]/a/div/div[2]/img");
	private static By lnkPlayerlukaku=By.linkText("/epl/players/2204");
	
	
	private static By lblHeight=By.cssSelector("span.formatted-height-weight.info-segment-data");
	private static By lblBirthdate=By.cssSelector("span.formatted-birthdate.info-segment-data");

	public  EPLSoccerPlayersPage(){        
		
	}
	
   public boolean VerifyPlayerInformation(WebDriver driver, Node node,DomParser parser )
    
	{	   	
	   	//waitForPageLoad(driver);
	    
	   	waitForPageLoad(driver);
	   	waitForPageLoad(driver);
	   	waitForPageLoad(driver);
	    Assert.assertTrue(SeleniumUtils.click(driver, lnkPlayerVardy2), "Could not click the First Player");
	    waitForPageLoad(driver);
	    Assert.assertTrue(driver.findElement(lblHeight).getText().contains(parser.getDataByNode(node, "Height")),"The height information not correct");
	    waitForPageLoad(driver);
	    waitForPageLoad(driver);
	    Assert.assertTrue(driver.findElement(lblBirthdate).getText().contains(parser.getDataByNode(node, "BirthDate")), "The Birthdate information not correct");
		return true;  	    
	}
	
	

}
