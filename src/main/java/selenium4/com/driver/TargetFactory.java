package selenium4.com.driver;

//import session4.com.utils.LogUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import selenium4.com.constants.FrameworkConstants;
import selenium4.com.enums.Target;
import selenium4.com.exceptions.TargetNotValidException;

import java.net.URL;

public class TargetFactory {

	public WebDriver createInstance() {
		Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
		WebDriver webdriver;

		switch (target) {
		case LOCAL:
			// Create new driver from Enum setup in BrowserFactory class
//			System.out.println("Luong debug");
			webdriver = BrowserFactory.valueOf(FrameworkConstants.BROWSER.toUpperCase()).createDriver();
			break;
		case REMOTE:
			// Create new driver on Cloud (Selenium Grid, Docker) from method below
			webdriver = createRemoteInstance(
					BrowserFactory.valueOf(FrameworkConstants.BROWSER.toUpperCase()).getOptions());
			break;
		default:
			throw new TargetNotValidException(target.toString());
		}
		return webdriver;
	}

	public WebDriver createInstance(String browser) {
//		System.out.println("Luong debug");
		Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
		WebDriver webdriver;
//		System.out.println(target);
		switch (target) {
		case LOCAL:
//			System.out.println(FrameworkConstants.BROWSER);
			// Create new driver from Enum setup in BrowserFactory class
			
			webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
			break;
		case REMOTE:
			// Create new driver on Cloud (Selenium Grid, Docker) from method below
			webdriver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
			break;
		default:
			throw new TargetNotValidException(target.toString());
		}
		return webdriver;
	}

	private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
		try {
			String gridURL = String.format("http://%s:%s", FrameworkConstants.REMOTE_URL,
					FrameworkConstants.REMOTE_PORT);

			remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
		} catch (java.net.MalformedURLException e) {
			// LogUtils.error("Grid URL is invalid or Grid Port is not available");
			// LogUtils.error(String.format("Browser: %s", capability.getBrowserName()), e);
		} catch (IllegalArgumentException e) {
			// LogUtils.error(String.format("Browser %s is not valid or recognized",
			// capability.getBrowserName()), e);
		}

		return remoteWebDriver;
	}

}