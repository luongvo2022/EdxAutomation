package Edx.com.pages;

import org.openqa.selenium.By;

import selenium4.com.helpers.WebElementsHelpers;

public class EdxLearnerHomePage {
	public By exploreCourse=By.xpath("//*[text()='Explore courses']");
	public By searchTexbox=By.name("searchfield-input");
	public By expectCourse=By.xpath("(//div[@class=\"pgn__card-header-title-md\"])[1]");
	
	public EdxLearnerHomePage() {
		// TODO Auto-generated constructor stub
	}
	public Boolean verifyExistingCourse(String courseName) {
		By courseHyperlink=By.xpath("//*[text()='"+courseName+"']");
		WebElementsHelpers.smartWait();
		System.out.println(WebElementsHelpers.verifyElementVisible(courseHyperlink));
		if (WebElementsHelpers.verifyElementVisible(courseHyperlink)==true){
//			
			WebElementsHelpers.clickElement(courseHyperlink);
			return true;
		}
		else {
			
			return false;
		}
	}
	public void searchCourse(String courseName) {
		WebElementsHelpers.scrollToElementToBottom(exploreCourse);
		WebElementsHelpers.clickElement(exploreCourse);
		WebElementsHelpers.smartWait();
		WebElementsHelpers.clearAndFillText(searchTexbox, courseName);
		WebElementsHelpers.scrollToElementToBottom(expectCourse);
	}
	
}
