package Edx.com.pages;
import static selenium4.com.helpers.WebElementsHelpers.*;
import selenium4.com.utils.LogUtils;
import java.util.List;

import org.openqa.selenium.By;

public class EdxCourseContentPage {
	public By Expland_all=By.xpath("//button[text()='Expand all']");
	public By Title=By.xpath("//div[@class=\"col-10 ml-3 p-0 font-weight-bold text-dark-500\"]/span[@class=\"align-middle\"]");
	public By Collapse=By.xpath("//button[@aria-label=\"Close\"]/span");
	public By SubTtitle=By.xpath("//span/a[contains(@href, '/course/')]");
	public EdxCourseContentPage() {
		// TODO Auto-generated constructor stub
	}
	
	public void clickExpland_all() {
		smartWait();
		clickElement(Expland_all);
	}
	
	public void clickExpland(String Title) {
		smartWait();
		By Expland=By.xpath("//*[contains(text(),\""+Title+"\")]/../../../span/button");
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
		scrollToElementToBottom(Title);
		LogUtils.info("Get list Title:"+getListElementsText(Title));
//		System.out.println(getListElementsText(Title));
		return getListElementsText(Title);
	}
	public List<String> getListSubTitle_content(){
		LogUtils.info("Get subTitle:"+getListElementsText(SubTtitle));
//		System.out.println(getListElementsText(SubTtitle));'
		System.out.println(getAttributeElement(SubTtitle, "href"));
		return getListElementsText(SubTtitle);
	}
}
