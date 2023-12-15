package Edx.com.pages;
import static selenium4.com.helpers.WebElementsHelpers.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class EdxOverviewPage {
	public By CourseName = By.xpath("//div[@class=\"col-md-7 pr-4\"]/h1");
	public By CourseSummary = By.xpath("//div[@class=\"p\"]");
	public By WhatLearn = By.xpath("//h1[@class=\"h1 nav-target pt-3 mt-3 pt-sm-5 mt-sm-2\"]");
	public By ShowMore = By.xpath("//button[text()='Show more' and @id='outcome']");
	public By WhatLearnContent = By.xpath("//div[@class=\"mt-2 html-data\"]/ul/li");
	public By Intructor_FullName=By.xpath("//h3[@class=\"lead font-weight-bold text-primary-100 mt-2 mb-3\"]");
	public By Intructor_Info=By.xpath("//span[@width=\"0\"]");
	public By enrollButton=By.xpath("//a[text()=\"Enroll\"]");
	public By CourseDuration=By.xpath("//div[contains(text(),'weeks')]");
	public EdxOverviewPage() {
		
	}
	
	public String getCourseName() {
		String text = getTextElement(CourseName);
		    
		    // Split the text using colon as the delimiter
		String[] parts = text.split(":",2);
		    
		    // Access the part you need, e.g., the part after the colon
	    if (parts.length > 1) {
	        return parts[1].trim(); // Use trim() to remove leading/trailing spaces
	    } else {
	        // Handle the case where there is no colon in the text
	        return text; // Return the original text
	    }
	}
	
	public String getCourseSummary() {
		return getTextElement(CourseSummary);
	}
	
	public List<String> getWhatLearn() {
		scrollToElementToBottom(WhatLearn);
		smartWait();
//		System.out.println("Luong debug");
		sleep(5);
		clickElement(ShowMore,5);
		sleep(5);
		return getListElementsText(WhatLearnContent);		
		
	}
	public List<String> getIntructor_FullName() {
		return getListElementsText(Intructor_FullName);
	}
	public List<String> getIntructor_Infor() {
		return getListElementsText(Intructor_Info);
	}
	
	public EdxLoginPage clickEnroll() {
//		scrollToElementToTop(enrollButton);
		
		clickElement(enrollButton);
		smartWait();
		return new EdxLoginPage();
	}
	public String getDurationCourse() {
		smartWait();
		scrollToElementToTop(CourseDuration);
		return getTextElement(CourseDuration);
		
	}
}
