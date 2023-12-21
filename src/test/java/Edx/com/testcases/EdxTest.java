package Edx.com.testcases;

import org.testng.annotations.*;
import Edx.com.common.BaseTest;
import Edx.com.common.WordDocumentWriter;
import Edx.com.pages.*;
import static selenium4.com.constants.FrameworkConstants.*;
import static selenium4.com.helpers.WebElementsHelpers.*;


public class EdxTest extends BaseTest {
	
	@Test(priority = 0)
	public void EdxAutomation() {
		String url;
		if (System.getProperty("COURSE_URL") != null) {
			url = System.getProperty("COURSE_URL").toLowerCase();
		} else {
			url = COURSE_URL.toLowerCase();
		}
		getURL(url);
		EdxFactory edxfactory=new EdxFactory();
		WordDocumentWriter doc=new WordDocumentWriter();
		EdxPage edx=edxfactory.createPage(EdxPageType.overView);
		String durationCourse=edx.getInfor(EdxContentType.DurationCourse);
		doc.addCourseName(edx.getInfor(EdxContentType.CourseName));
		doc.addCourseSummary(edx.getInfor(EdxContentType.CourseSummary));
		//Whatlearn
		doc.addWhatLearn(edx.getListInfor(EdxContentType.WhatLearn));
		//Intructor
		doc.addIntructor(edx.getListInfor(EdxContentType.Intructor_FullName), edx.getListInfor(EdxContentType.Intructor_Info));
		edx.takeAction(EdxActionType.clickEnroll);
		edx=edxfactory.createPage(EdxPageType.login);
		sleep(10);
		edx.takeAction(EdxActionType.login);
		
//		loginPage.LoginToEdx(userName, password);
//		EdxCourseContentPage courseContent=loginPage.clickContinueButton();
		edx=edxfactory.createPage(EdxPageType.courseContent);
		doc.addCourseContent(edx);
		doc.addDurationCourse(durationCourse);
		doc.addCourseLink(url);
		doc.saveToFile("OutputFiles/course1.docx");
//	    System.out.println(edx.getIntructor_FullName().get(0));
		
	
	}
	@Test
	public void failTC() {
		String url;
		if (System.getProperty("COURSE_URL") != null) {
			url = System.getProperty("COURSE_URL").toLowerCase();
		} else {
			url = COURSE_URL.toLowerCase();
		}
		getURL(url);
		EdxFactory edxfactory=new EdxFactory();
		EdxPage edx=edxfactory.createPage(EdxPageType.overView);
		edx.getInfor(EdxContentType.CourseName);
		edx=edxfactory.createPage(EdxPageType.login);
		edx.takeAction(EdxActionType.login);
	}
	
}
