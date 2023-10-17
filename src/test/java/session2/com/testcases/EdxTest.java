package session2.com.testcases;

import org.testng.annotations.Test;
import java.util.List;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import session2.com.common.BaseTest;
import session2.com.common.WordDocumentWriter;
import session2.com.pages.EdxPage;
import session2.com.utils.UserInput;
import static session2.com.helpers.WebElementsHelpers.*;

@Epic("Regression Test")
@Feature("Edx Test")
public class EdxTest extends BaseTest {
	private static final String fontDefault="Calibri";
	private static final double sizeDefault=13.5;
	private static final String colorDefault="0f0b01";
	private static final String blueColor="34a0c4";
	@Test(priority = 0)
	public void EdxAutomation() {
		
		EdxPage edx= new EdxPage();
		WordDocumentWriter doc=new WordDocumentWriter();
		doc.addCourseName(edx.getCourseName());
		doc.addCourseSummary(edx.getCourseSummary());
		doc.addContent("What You'll Learn:\n", fontDefault, sizeDefault, true, false, false, colorDefault);
		doc.addBulletList(edx.getWhatLearn(),fontDefault,sizeDefault,colorDefault);
		//Intructor
		List<String> instructorFullName=edx.getIntructor_FullName();
		List<String> instructorInfo=edx.getIntructor_Infor();
		doc.addIntructor(instructorFullName, instructorInfo);
	    doc.saveToFile("OutputFiles/course1.docx");
	    System.out.println(edx.getIntructor_FullName().get(0));
		
	}
	
	
}
