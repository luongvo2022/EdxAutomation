package Edx.com.pages;

import static session2.com.helpers.WebElementsHelpers.*;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

//import session2.com.driver.DriverManager;

public class EdxLoginPage {
//	@FindBy(className="btn btn-primary w-50 first-focus")
//	WebElement SignInButton_Menubar;
//	public By SignInButton_Menubar=By.xpath("//a[@class=\"btn btn-primary w-50 first-focus\"]");
//	public By MobileMenuButton=By.xpath("//button[@class=\"mobile-menu-button icon-button small p-0\"]");
	public By SignInTab=By.xpath("//a[@id=\"controlled-tab-tab-/login\"]");
	public By UserNameTextbox=By.xpath("//input[@name=\"emailOrUsername\"]");
	public By PasswordTextbox=By.xpath("//input[@name=\"password\"]");
	public By SignInButton=By.xpath("//span[text()=\"Sign in\"]");
	public By SignInButton_Desktop=By.xpath("//a[text()='Sign in']");
	public By ContinueButton=By.name("audit_mode");
	public EdxLoginPage() {
		// TODO Auto-generated constructor stub
		
		
	}
	
//	public void clickSignInButton() {
//		
//		
////		WebElementsHelpers.sleep(10);
////		System.out.println(verifyElementVisible(MobileMenuButton));
//		if (verifyElementVisible(MobileMenuButton)== true) {
//			scrollToElementToTop(MobileMenuButton);
//			clickElement(MobileMenuButton);
//			clickElement(SignInButton_Menubar);
//		}
//		else {
//			scrollToElementToTop(SignInButton_Desktop);
//			clickElement(SignInButton_Desktop);
//		}
//	}
//	
	public void clickSignInTab() {
		smartWait();
		clickElement(SignInTab);
	}
	
	
	public void setUserName(String userName) {
		clearAndFillText(UserNameTextbox, userName);
	}
	public void setPassword(String userName) {
		clearAndFillText(PasswordTextbox, userName);
	}
	public void clickSigInButton() {
		clickElement(SignInButton);
	}
	
	public void LoginToEdx(String userNameString, String passwordString) {
		waitForElementVisible(SignInTab);
		this.clickSignInTab();
		this.setUserName(userNameString);
		this.setPassword(passwordString);
		this.clickSigInButton();
		
	}
	public void clickContinueButton() {
		smartWait();
		clickElement(ContinueButton);
		
	}
}
