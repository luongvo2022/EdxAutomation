package Edx.com.testcases;

import org.testng.annotations.Test;

import Edx.com.common.BaseTest;
import Edx.com.common.WordDocumentWriter;
import Edx.com.pages.EdxCourseContentPage;
import Edx.com.pages.EdxLearnerHomePage;
import Edx.com.pages.EdxLoginPage;
import Edx.com.pages.EdxOverviewPage;

import java.util.List;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import session2.com.helpers.WebElementsHelpers;
import session2.com.utils.UserInput;
import static session2.com.helpers.WebElementsHelpers.*;

@Epic("Regression Test")
@Feature("Edx Test")
public class EdxTest extends BaseTest {
	public String userName="luongvo2022";
	public String password="kdAVt6`m";
	@Test(priority = 0)
	public void EdxAutomation() {
		String URL=System.getenv("Course URL");
		getURL(URL);
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
		loginPage.LoginToEdx(userName, password);
	
		loginPage.clickContinueButton();
		doc.addCourseContent();
		doc.addDurationCourse(durationCourse);
		doc.saveToFile("OutputFiles/course1.docx");
//	    System.out.println(edx.getIntructor_FullName().get(0));
		
	}
	
	
}
