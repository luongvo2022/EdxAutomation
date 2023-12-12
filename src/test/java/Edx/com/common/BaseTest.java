package Edx.com.common;
import selenium4.com.listeners.TestListener;

import static selenium4.com.constants.FrameworkConstants.BROWSER;

//import session2.com.projects.cms.CommonPageCMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import selenium4.com.driver.DriverManager;
import selenium4.com.driver.TargetFactory;
import selenium4.com.helpers.PropertiesHelpers;
import selenium4.com.helpers.WebElementsHelpers;

@Listeners({TestListener.class})
public class BaseTest {
	@BeforeMethod(alwaysRun = true)
	public void BeginWebTest() {
		String browser;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		if (System.getProperty("BROWSER") != null) {
			browser = System.getProperty("BROWSER").toLowerCase();
		} else {
			browser = BROWSER.toLowerCase();
		}
		//System.out.println("----- Browser in BeforeMethod: " + browser);
		WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();
		
	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		DriverManager.quit();
	}

	public WebDriver createBrowser(@Optional("chrome") String browser) {
		PropertiesHelpers.loadAllFiles();
		WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
		return DriverManager.getDriver();
	}
}
