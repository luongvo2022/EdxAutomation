package Edx.com.common;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.testng.annotations.Optional;
import selenium4.com.utils.LogUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import Edx.com.pages.EdxActionType;
import Edx.com.pages.EdxContentType;
import Edx.com.pages.EdxCourseContentPage;
import Edx.com.pages.EdxPage;

public class WordDocumentWriter {
	private XWPFDocument document;
	private static final String fontDefault="Calibri";
	private static final double sizeDefault=13.5;
	private static final String colorDefault="0f0b01";
	private static final String blueColor="34a0c4";
	private static final String url_color="61bbd8";
	public WordDocumentWriter() {
		// TODO Auto-generated constructor stub
		document = new XWPFDocument();
		LogUtils.info("Create a document");
	}
	public XWPFParagraph addContent(String content, @Optional(fontDefault) String fontName, double fontSize, boolean isBold, boolean isItalic, boolean isUnderline, String color) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        // Set content
        run.setText(content);

        // Set font
        run.setFontFamily(fontName);

        // Set font size
        run.setFontSize(fontSize);

        // Set bold, italic, and underline
        run.setBold(isBold);
        run.setItalic(isItalic);
        if (isUnderline) {
            run.setUnderline(UnderlinePatterns.SINGLE);
        }

        // Set text color
        if (color != null && !color.isEmpty()) {
            run.setColor(color);
        }
        return paragraph;
    }
	public void addCourseName(String content) {
		addContent(content,fontDefault,16 , false , false, false,colorDefault );
	}
	public void addCourseSummary(String content) {
		addContent(content,fontDefault,sizeDefault , false , false, false,colorDefault );
	}
	
	public void addBulletList(List<String> bulletList, String fontName, double fontSize, String color) {
        for (String point : bulletList) {
            addBullets(point, fontName, fontSize, color);
        }
    }
	
	public void addBullets(String content, String fontName, double fontSize, String color) {
		XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        // Set content
        run.setText(content);

        // Set font
        run.setFontFamily(fontName);

        // Set font size
        run.setFontSize(fontSize);

    
        // Set text color
        if (color != null && !color.isEmpty()) {
            run.setColor(color);
        }

        // Set bullet properties
        paragraph.setNumID(BigInteger.valueOf(1));
//        return paragraph;
    }
	
	public void setBullet(XWPFParagraph paragraph, BigInteger bulletId) {
        if (paragraph.getCTP().getPPr() == null) {
            paragraph.getCTP().addNewPPr();
        }
        if (paragraph.getCTP().getPPr().getNumPr() == null) {
            paragraph.getCTP().getPPr().addNewNumPr();
        }

        CTDecimalNumber ctDecimalNumber = paragraph.getCTP().getPPr().getNumPr().addNewIlvl();
        ctDecimalNumber.setVal(BigInteger.valueOf(0));
        ctDecimalNumber = paragraph.getCTP().getPPr().getNumPr().addNewNumId();
        ctDecimalNumber.setVal(bulletId);
	}
	
	public XWPFParagraph addContent(XWPFParagraph paragraph,String content, String fontName, double fontSize, String color) {
		 XWPFRun run = paragraph.createRun();

	        // Set content
	        run.setText(content);

	        // Set font
	        run.setFontFamily(fontName);

	        // Set font size
	        run.setFontSize(fontSize);

	    
	        // Set text color
	        if (color != null && !color.isEmpty()) {
	            run.setColor(color);
	        }
	        return paragraph;
	}
	public void addIntructor(List<String> FullName, List<String> info ) {
		XWPFParagraph paragraph;
		XWPFParagraph paragraph1;
		paragraph=addContent("Instructor: ", fontDefault, sizeDefault, true, false, false, blueColor);
//		System.out.println("THe size="+FullName.size());
		if (FullName.size()>1) {
			for(int i=0;i<FullName.size();i++) {
				paragraph1=addContent(FullName.get(i),fontDefault, sizeDefault,false, false, false, colorDefault);
				addContent(paragraph1, " - ", fontDefault, sizeDefault, colorDefault);
				addContent(paragraph1, info.get(i),fontDefault, sizeDefault, colorDefault);
				paragraph1.setNumID(null);
//				setBullet(paragraph1, BigInteger.valueOf(7));
				
				
			}
		}
		else {
			addContent(paragraph, FullName.get(0), fontDefault, sizeDefault, colorDefault);
			addContent(paragraph, " - ", fontDefault, sizeDefault, colorDefault);
			addContent(paragraph, info.get(0),fontDefault, sizeDefault, colorDefault);
		}
		
	}
	
	public void addCourseContent(EdxPage courseContent ) {
		this.addContent("Course contents:", fontDefault, sizeDefault, true, false, false, blueColor);
		List<String> listTitle=courseContent.getListInfor(EdxContentType.Title_Content);
		XWPFParagraph paragraph;
		int i=1;
		for (String title: listTitle) {
			 i++;
			 int j=1;
			 paragraph = document.createParagraph();
             XWPFRun run = paragraph.createRun();
             run.setText(title);
//             run.setBold(true);
             run.setFontSize(sizeDefault);
             courseContent.takeAction(EdxActionType.clickExpland,title);
             for (String item :courseContent.getListInfor(EdxContentType.SubTitle_content)) {
                 
            	 paragraph = document.createParagraph();
                 paragraph.setNumID(BigInteger.valueOf(i)); // Set numbering to "1" for each section
                 paragraph.setNumILvl(BigInteger.valueOf(1)); // Set indentation level to "0"
                 
                 addHyperlink(paragraph, item, courseContent.getInfor(EdxContentType.URLofCourseContent, j));
//                 XWPFRun itemRun = paragraph.createRun();
//                 itemRun.setText(item);
//                 run.setFontSize(sizeDefault);
                 j++;
             }
             courseContent.takeAction(EdxActionType.clickCollapse);
             
		}
	}
	public void addWhatLearn(List<String> content) {
		this.addContent("What You'll Learn:\n", fontDefault, sizeDefault, true, false, false, colorDefault);
		this.addBulletList(content,fontDefault,sizeDefault,colorDefault);
	}
	public void addDurationCourse(String content) {
		this.addContent(this.addContent("Duration Course:", fontDefault, sizeDefault, true, false, false, colorDefault), content, fontDefault, sizeDefault, colorDefault);
	}
	
	public void addCourseLink(String courselink) {
		XWPFParagraph paragraph =this.addContent("Course link: ", fontDefault, sizeDefault, true, false, false, colorDefault);
        // Create a run and set the text (URL)
        XWPFRun run = paragraph.createHyperlinkRun(courselink);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setColor(url_color);
        run.setText(courselink);
	}
	
	public void addHyperlink(XWPFParagraph paragraph, String Text, String hyperlink) {
        // Create a hyperlink run
        XWPFRun run = paragraph.createHyperlinkRun(hyperlink);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setColor(url_color);
        run.setText(Text);
    }
	public void saveToFile(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            document.write(fos);
            System.out.println("Word document created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}