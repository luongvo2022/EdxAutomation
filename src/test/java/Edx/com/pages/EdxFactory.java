package Edx.com.pages;

public class EdxFactory extends AbstractFactory{
	@Override
	public EdxPage createPage(EdxPageType type) {
		if (type==EdxPageType.overView)
			return new EdxOverviewPage();
		else if (type==EdxPageType.login)
			return new EdxLoginPage();
		else if (type==EdxPageType.courseContent)
			return new EdxCourseContentPage();
		else
			return null;
	}
}
