package Edx.com.pages;

import static session2.com.helpers.WebElementsHelpers.*;
import org.openqa.selenium.By;

public class HomePage {

	By textHomePageUserName = By.xpath("//table//tr[@class='heading3']");
	By btnLogout = By.xpath("//a[contains(text(),'Log out')]");

	public String getHomePageUserName() {
		return getTextElement(textHomePageUserName);
	}

	public LoginPage clickLogout() {
		clickElement(btnLogout);
		return new LoginPage();
	}
}
