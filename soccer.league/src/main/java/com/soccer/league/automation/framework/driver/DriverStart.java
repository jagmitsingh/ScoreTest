package com.soccer.league.automation.framework.driver;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class DriverStart {
	
	
	public ThreadLocal<RemoteWebDriver> threadDriver = null;
	 
    public static WebDriver driver;	
	public WebDriverWait wait;
	
	
	/**
	 * Setup method executed before the start of a test.  
	 * 
	 */	

	@BeforeMethod(alwaysRun = true)	
	@Parameters({"seleniumHost","seleniumPort","browser","webSite"})
	
	public final void genericSetUp(String seleniumHost, String seleniumPort, String browser, String webSite) throws IOException {
		driver = loadURL(seleniumHost,seleniumPort, browser,webSite);			
		
	}
	
	
	/**
	 * Loads the application under-test 
	 * 
	 * @param webSite, browser, seleniumHost, seleniumPort
	 * @return load the application under test
	 * @throws IOException 
	 */
	public WebDriver loadURL(String seleniumHost, String seleniumPort,String browser, String webSite) throws IOException  {
	
		// get the browser specific driver and load the application under test
			
		driver = getWebDriver(seleniumHost, seleniumPort, browser);
		wait = new WebDriverWait(driver, 30);
		driver.get(webSite);

		// Maximize the window
		driver.manage().window().maximize();
		return driver;

	}
	
	/**
	 * Returns the browser specific driver
	 * 
	 * @param browser, seleniumHost, seleniumPort
	 * @return Browser specific driver
	 * @throws IOException 
	 */
	
 public WebDriver getWebDriver(String seleniumHost, String seleniumPort, String browser) throws IOException {
	 
	   switch (BrowserType.valueOf(browser)) {
				
		case FIREFOX:
			return new FirefoxDriver();
		case IE:
			
			threadDriver = new ThreadLocal<RemoteWebDriver>();
			DesiredCapabilities dc = new DesiredCapabilities();
			 
			dc.setBrowserName("iexplorer");
			
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("requireWindowFocus", true);
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setCapability("enableElementCacheCleanup", true);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			ieCapabilities.setCapability("browserstack.ie.enablePopups", false);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			threadDriver.set(new RemoteWebDriver(new URL("http://"+seleniumHost+":"+seleniumPort+"/wd/hub"), dc));
			System.out.println("URL = " + "http://"+seleniumHost+":"+seleniumPort+"/wd/hub");
					
			return threadDriver.get();
		
		default:
			throw new RuntimeException("Browser type unsupported");
		}
		
     }
 
 /**
	 * Selenium UI tests should be run on the different browsers and this function returns the Browser type
	 * 	 
	*/	

	public enum BrowserType {
		FIREFOX("firefox"), IE("iexplore");
		private String label;

		private BrowserType(String label) {
			this.label = label;
		}

		public String Value() {
			return label;
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public final void tearDown(ITestResult result) throws IOException {

		String status = "PASS";
		
		// Capture screen shot in case test has failed.
		try {
			
		// Closing the browser and closing driver
		driver.quit();
			
		}
		 catch (Exception e) {
			
		}

    }
	
}
