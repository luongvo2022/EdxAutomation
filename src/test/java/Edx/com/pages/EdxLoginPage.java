package Edx.com.pages;

import static selenium4.com.helpers.WebElementsHelpers.*;
import static selenium4.com.constants.FrameworkConstants.userName;
import static selenium4.com.constants.FrameworkConstants.password;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import selenium4.com.utils.LogUtils;

//import session2.com.driver.DriverManager;

public class EdxLoginPage extends EdxPage  {
//	@FindBy(className="btn btn-primary w-50 first-focus")
//	WebElement SignInButton_Menubar;
//	public By SignInButton_Menubar=By.xpath("//a[@class=\"btn btn-primary w-50 first-focus\"]");
//	public By MobileMenuButton=By.xpath("//button[@class=\"mobile-menu-button icon-button small p-0\"]");
	public By SignInTab=By.xpath("//a[text()='Sign in']");
	public By UserNameTextbox=By.xpath("//input[@name=\"emailOrUsername\"]");
	public By PasswordTextbox=By.xpath("//input[@name=\"password\"]");
	public By SignInButton=By.xpath("//span[text()=\"Sign in\"]");
	public By SignInButton_Desktop=By.xpath("//a[text()='Sign in']");
	public By ContinueButton=By.name("audit_mode");
	public EdxLoginPage() {
		// TODO Auto-generated constructor stub
		
		
	}
	@Override
	public void takeAction(EdxActionType action) {
		switch(action){
			case clickSignInTab:
				clickSignInTab();
				break;
			case login:
				LoginToEdx(userName,password);
				break;
			default:
				LogUtils.info("Cannot run action"+action);
		}
	}
	@Override
	public String getInfor(EdxContentType type) {
		return null;
	}
	@Override
	public List<String> getListInfor(EdxContentType type){
		return null;
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
		sleep(5);
		waitForElementVisible(SignInTab);
		this.clickSignInTab();
		this.setUserName(userNameString);
		this.setPassword(passwordString);
		this.clickSigInButton();
		this.clickContinueButton();
		
	}
	public void clickContinueButton() {
		smartWait();
		clickElement(ContinueButton);
		sleep(10);

		
	}
}
