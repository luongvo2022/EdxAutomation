package session2.com.pages;

import static session2.com.helpers.WebElementsHelpers.*;
import org.openqa.selenium.By;

import session2.com.driver.DriverManager;
import session2.com.utils.LogUtils;

public class LoginPage {

	public By inputUserName = By.name("uid");
	public By inputPassword = By.name("password");
	public By textTitle = By.className("barone");
	public By buttonLogin = By.name("btnLogin");

	public LoginPage() {
	}

	public void setUserName(String strUserName) {
		setText(inputUserName, strUserName);
	}

	public void setPassword(String strPassword) {
		setText(inputPassword, strPassword);
	}

	public void clickLogin() {
		clickElement(buttonLogin);
	}

	public String getLoginTitle() {
		return getTextElement(textTitle);
	}

	public LoginPage clickOkOnAlertAppear() {
		if (verifyAlertPresent(10)) {
			DriverManager.getDriver().switchTo().alert().accept();
		} else {
			LogUtils.info("No Alert disappear ");
		}

		return this;
	}

	public HomePage loginToApplication(String strUserName, String strPasword) {
		this.setUserName(strUserName);
		this.setPassword(strPasword);
		this.clickLogin();

		return new HomePage();
	}
}
