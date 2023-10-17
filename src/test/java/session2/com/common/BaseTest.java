package session2.com.common;

import session2.com.driver.DriverManager;
import session2.com.driver.TargetFactory;
import session2.com.helpers.PropertiesHelpers;
import session2.com.helpers.WebElementsHelpers;
import session2.com.utils.UserInput;
//import session4.com.listeners.TestListener;
//import session2.com.projects.cms.CommonPageCMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

//@Listeners({TestListener.class})
public class BaseTest {
	@Parameters("BROWSER")
	@BeforeMethod(alwaysRun = true)
	public void BeginWebTest(@Optional("chrome") String browser) {
//		UserInput userinput= new UserInput();
//	    String Course_URL=userinput.getURLCourse();
//	    browser=userinput.getBrowser();
//	    userinput.closeScanner();
	    //Create Driver
		System.setProperty("webdriver.http.factory", "jdk-http-client"); //xu ly exception
		WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser)); //run paral with nhieu thread
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();
		WebElementsHelpers.getURL("https://www.edx.org/learn/coding/university-of-british-columbia-how-to-code-complex-data?utm_source=lms_catalog_service_user&utm_medium=affiliate_partner");
		
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
