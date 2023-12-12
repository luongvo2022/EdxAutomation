package Edx.com.testcases;

import org.testng.annotations.*;
import Edx.com.common.BaseTest;
import Edx.com.common.WordDocumentWriter;
import Edx.com.pages.EdxLoginPage;
import Edx.com.pages.EdxOverviewPage;
import static selenium4.com.constants.FrameworkConstants.COURSE_URL;
import static selenium4.com.helpers.WebElementsHelpers.*;
import selenium4.com.helpers.ScreenshotHelpers;


//@Epic("Regression Test")
//@Feature("Edx Test")
public class EdxTest extends BaseTest {
	public String userName="luongvo2022";
	public String password="kdAVt6`m";
	@Test(priority = 0)
	public void EdxAutomation() {
		String url;
		if (System.getProperty("COURSE_URL") != null) {
			url = System.getProperty("COURSE_URL").toLowerCase();
		} else {
			url = COURSE_URL.toLowerCase();
		}
		getURL(url);
		EdxOverviewPage edxOverview= new EdxOverviewPage();
		WordDocumentWriter doc=new WordDocumentWriter();
		String durationCourse=edxOverview.getDurationCourse();
		doc.addCourseName(edxOverview.getCourseName());
		doc.addCourseSummary(edxOverview.getCourseSummary());
		//Whatlearn
		doc.addWhatLearn(edxOverview.getWhatLearn());
		//Intructor
		doc.addIntructor(edxOverview.getIntructor_FullName(), edxOverview.getIntructor_Infor());
		EdxLoginPage loginPage=edxOverview.clickEnroll();
		sleep(10);
		loginPage.LoginToEdx(userName, password);
		ScreenshotHelpers.getScreenshotFile("screenshotUsingRobotClass_BeforeClick");
		loginPage.clickContinueButton();
		doc.addCourseContent();
		doc.addDurationCourse(durationCourse);
		doc.saveToFile("OutputFiles/course1.docx");
//	    System.out.println(edx.getIntructor_FullName().get(0));
		
	}
	
	
}
