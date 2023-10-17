package session2.com.pages;
import static session2.com.helpers.WebElementsHelpers.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class EdxPage {
	private static final By CourseName = By.xpath("//div[@class=\"col-md-7 pr-4\"]/h1");
	private static final By CourseSummary = By.xpath("//div[@class=\"p\"]");
	private static final By WhatLearn = By.xpath("//h1[@class=\"h1 nav-target pt-3 mt-3 pt-sm-5 mt-sm-2\"]");
	private static final By ShowMore = By.xpath("//button[text()='Show more' and @id='outcome']");
	private static final By WhatLearnContent = By.xpath("//div[@class=\"mt-2 html-data\"]/ul/li");
	private static final By Intructor_FullName=By.xpath("//h3[@class=\"lead font-weight-bold text-primary-100 mt-2 mb-3\"]");
	private static final By Intructor_Info=By.xpath("//span[@width=\"0\"]");
	
	public String getCourseName() {
		return getTextElement(CourseName);
	}
	
	public String getCourseSummary() {
		return getTextElement(CourseSummary);
	}
	
	public List<String> getWhatLearn() {
		scrollToElementToBottom(WhatLearn);
		smartWait();
		clickElement(ShowMore);
		return getListElementsText(WhatLearnContent);		
		
	}
	public List<String> getIntructor_FullName() {
		return getListElementsText(Intructor_FullName);
	}
	public List<String> getIntructor_Infor() {
		return getListElementsText(Intructor_Info);
	}
}
