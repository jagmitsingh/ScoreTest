package com.soccer.league.EPL.testscripts;

import org.dom4j.Node;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.soccer.league.EPL.PageObjectRepository.EPLLeague.EPLSoccerPage;
import com.soccer.league.EPL.PageObjectRepository.EPLLeague.EPLSoccerPlayersPage;
import com.soccer.league.EPL.PageObjectRepository.sharedlib.ScoreHomePage;
import com.soccer.league.automation.framework.driver.DriverStart;
import com.soccer.league.automation.framework.frameworkUtils.XMLParser.DomParser;


public class VerifyPlayersInformation extends DriverStart {
	
    Node player1;	
	@Test
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void VerifyPlayers(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		DomParser parser = new DomParser("EPLData.xml");				   
		player1 = parser.getNode("TC_01");	
		verifyPlayersInformation(seleniumHost, seleniumPort, browser, webSite, player1, parser);
	}
	
	public boolean verifyPlayersInformation(String seleniumHost, int seleniumPort,String browser, String webSite, Node template1,DomParser parser ) throws Exception{	
		boolean returnValue=true;	
		try{
			
		   //--------------------------------------------------------------------//
		   //  Step-1: Verify that the loaded URL shows the Score Logo  
		   //--------------------------------------------------------------------//	
		   	
            ScoreHomePage scoreHomePage = new ScoreHomePage();
		   	
		   //--------------------------------------------------------------------//
		   //  Step-2: Navigate to Main Menu -> Trending -> EPLSoccer
		   //--------------------------------------------------------------------//
			
            scoreHomePage.goToMainMenuTrendingEPLSoccer(driver);            
			
			//--------------------------------------------------------------------//
			//  Step-3: Visit the EPLSoccer link Page and click on EPLPlayers link
			//--------------------------------------------------------------------//
									
			EPLSoccerPage eplSoccerPage = new EPLSoccerPage();
			eplSoccerPage.goToEPLPlayers(driver);
            
			//--------------------------------------------------------------------//
			//  Step-4:  Visit the EPLSoccerPlayer Page and select one of the player and verify information
			//--------------------------------------------------------------------//
			
			EPLSoccerPlayersPage eplSoccerPlayersPage = new EPLSoccerPlayersPage();
			eplSoccerPlayersPage.VerifyPlayerInformation(driver,player1,parser);		
			

		}
		
		catch(RuntimeException e){
			e.printStackTrace();			
		}
		return returnValue;
	}
	
}