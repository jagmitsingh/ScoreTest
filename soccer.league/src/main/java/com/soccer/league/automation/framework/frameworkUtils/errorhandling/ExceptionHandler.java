package com.soccer.league.automation.framework.frameworkUtils.errorhandling;

import org.openqa.selenium.WebDriver;

public class ExceptionHandler extends Exception {

	private String customMessage = "";
	private WebDriver driver = null;
	private String message[];
	
	/**
	 * 
	 * @param e
	 * @param driver
	 * @param customMessage
	 */
    public ExceptionHandler(Exception e, WebDriver driver, String customMessage){
    	this.customMessage = customMessage;
    	this.driver        = driver;
    	
    	message = customMessage.split("");
		
    	if(e.toString().contains("ArrayIndexOutOfBoundsException")){
    		
    		//Take a Screenshot and output the custom message 
    		//e.getMessage();
			
		}
		else if(e.toString().contains("RuntimeException")){
			
			//Take a Screenshot and output a custom message 
    		//e.getMessage();
			
		}
		else if(e.toString().contains("IOException")){
			//Take a Screenshot and output a custom message 
    		//e.getMessage();
			
		}
		else if(e.toString().contains("NoSuchElementException")){
			//Take a Screenshot and output a custom message 
    		//e.getMessage();
			
		}
		else if(e.toString().contains("InterruptedException")){
			//Take a Screenshot and output a custom message 
    		//e.getMessage();
			
		}
		else if(e.toString().contains("PageNotLoadedException")){
			//Take a Screenshot and output a custom message 
    		//e.getMessage();
			
		}
		
    }
	
	
	
}
