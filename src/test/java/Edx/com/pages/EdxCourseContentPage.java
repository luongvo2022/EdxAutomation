package Edx.com.pages;
import static selenium4.com.constants.FrameworkConstants.password;
import static selenium4.com.constants.FrameworkConstants.userName;
import static selenium4.com.helpers.WebElementsHelpers.*;
import selenium4.com.utils.LogUtils;
import java.util.List;

import org.openqa.selenium.By;


public class EdxCourseContentPage extends EdxPage{
	public By Expland_all=By.xpath("//button[text()='Expand all']");
	public By Title=By.xpath("//div[@class=\"col-10 ml-3 p-0 font-weight-bold text-dark-500\"]/span[@class=\"align-middle\"]");
	public By Collapse=By.xpath("//button[@aria-label=\"Close\"]/span");
	public By SubTtitle=By.xpath("(//span/a[contains(@href, '/course/')])");
	public EdxCourseContentPage() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void takeAction(EdxActionType action, String title) {
		switch(action){
			case clickExpland:
				clickExpland(title);
				break;
			default:
				LogUtils.info("Cannot run action"+action);
		}
	}
	@Override
	public void takeAction(EdxActionType action) {
		switch(action){
			case clickCollapse:
				clickCollapse();
				break;
			default:
				LogUtils.info("Cannot run action"+action);
			}
	}
	
	@Override
	public String getInfor(EdxContentType type) {
		switch(type) {
			default:
				LogUtils.info("Cannot get list infor"+type);
				return null;
		}
	}
	@Override
	public String getInfor(EdxContentType type, int i) {
		switch(type) {
			case URLofCourseContent:
				return getURLofCourseContent(i);
				
			default:
				LogUtils.info("Cannot get list infor"+type);
				return null;
		}
	}
	@Override
	public List<String> getListInfor(EdxContentType type){
		switch(type) {
			case Title_Content:
				return getListTitle_Content();
				
			case SubTitle_content:
				return getListSubTitle_content();
				
			default:
				LogUtils.info("Cannot get list infor"+type);
				return null;
		}
	}
	public void clickExpland_all() {
		smartWait();
		clickElement(Expland_all);
	}
	
	public void clickExpland(String Title) {
		smartWait();
		By Expland=By.xpath("//*[contains(text(),\""+Title+"\")]/../../../span/button");
		waitForElementVisible(Expland);
		clickElement(Expland);
	}
	
	public void clickCollapse() {
		smartWait();
		clickElement(Collapse);
		sleep(5);
	}
	
	public List<String> getListTitle_Content() {
		smartWait();
		sleep(5);
//		scrollToElementToBottom(Title);
		LogUtils.info("Get list Title:"+getListElementsText(Title));
//		System.out.println(getListElementsText(Title));
		return getListElementsText(Title);
	}
	public List<String> getListSubTitle_content(){
		LogUtils.info("Get subTitle:"+getListElementsText(SubTtitle));
//		System.out.println(getListElementsText(SubTtitle));'
//		System.out.println(getAttributeElement(SubTtitle, "href"));
		return getListElementsText(SubTtitle);
	}
	public String getURLofCourseContent(int i) {
		By xpath=By.xpath("(//span/a[contains(@href, '/course/')])["+ String.valueOf(i)+"]");
		LogUtils.info("Get Hyperlink:\n"+getAttributeElement(xpath, "href"));
		return getAttributeElement(xpath, "href");
	}
}
