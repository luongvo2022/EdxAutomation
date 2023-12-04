package Edx.com.common;
//import session4.com.listeners.TestListener;
//import session2.com.projects.cms.CommonPageCMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import session2.com.driver.DriverManager;
import session2.com.driver.TargetFactory;
import session2.com.helpers.PropertiesHelpers;
import session2.com.helpers.WebElementsHelpers;

//@Listeners({TestListener.class})
public class BaseTest {
	@Parameters({"browser","course_url"})
	@BeforeMethod(alwaysRun = true)
	public void BeginWebTest(String browser,String course_url) {
//		UserInput userinput= new UserInput();
//	    String Course_URL=userinput.getURLCourse();
//	    browser=userinput.getBrowser();
//	    userinput.closeScanner();
	    //Create Driver
//		PropertiesHelpers.loadAllFiles();
		System.setProperty("webdriver.http.factory", "jdk-http-client"); //xu ly exception
		WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser)); //run paral with nhieu thread
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();
		
		WebElementsHelpers.getURL(course_url);
		
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
