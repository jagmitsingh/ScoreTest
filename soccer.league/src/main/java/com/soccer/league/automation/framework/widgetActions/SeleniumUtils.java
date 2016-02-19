package com.soccer.league.automation.framework.widgetActions;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.soccer.league.automation.framework.frameworkUtils.errorhandling.ExceptionHandler;

public class SeleniumUtils {
	
	public SeleniumUtils() {
	}
	
	public SeleniumUtils(WebDriver driver) {
		SeleniumUtils.driver = driver;
	}
	
	public static WebDriver driver;
	private static Boolean result = true;
	private static final String deliminator = "####";
	
	private static By lnkScoreLogo2 =By.cssSelector("div.thescore-logo");
	public static int WAIT_TIME = 15;
	
	/**
	 * Verify the presence of the element 
	 * @param element    Web element 
	 * @return           True if the element is present 
	 */
	public static boolean isElementPresent(WebDriver driver, By element) {
		try {	
		
		if (driver.findElement(element).isDisplayed()) {
			result= true;
		} 
		}
		catch (Exception e) {
			
			result = false;
			new ExceptionHandler(e, driver, "CustomMessage");
		}

		return result;
	}
	
	
	
	
	/**
	 * To click an element on the screen
	 * 
	 * @param driver  
	 * @return
	 */
	
	public static boolean click(WebDriver driver,By ElementName){
		try {
			
			if (driver.findElement(ElementName).isDisplayed()) {
				driver.findElement(ElementName).click();
				result= true;
			} 
			
		} catch (Exception e) {
			
			result = false;
			new ExceptionHandler(e, driver, "CustomMessage");
			
		}
		
		return result;
	}

	
	/**
	 * waitForPageLoad function is used to wait a page to load completely
	 * 
	 * @param selenium
	 * @return boolean
	 * 
	 * @since OCt 31,2014
	 */

	public boolean waitForPageLoad(WebDriver driver) {
		try {

			int j = 0;
			try {
				Thread.sleep(3000);
				if (isElementPresent(driver, lnkScoreLogo2)) {
					while (isElementPresent(driver, lnkScoreLogo2) && j < (WAIT_TIME)) {
						Thread.sleep(100);
						j++;
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Used to get the custom attribute value
	 * 
	 * @param operation
	 * @param elementLocator1
	 * @param optional
	 * @param status
	 * @param screenShot
	 * @param callingMethodAndLineNumber
	 * @return
	 */
	protected static String getCustomAttributeValue(String operation, String elementLocator1, String optional,
			String status, String screenShot, String callingMethodAndLineNumber) {

		return operation + deliminator + elementLocator1 + deliminator + optional + deliminator + status + deliminator
				+ screenShot + deliminator + callingMethodAndLineNumber;

	}
	

}
