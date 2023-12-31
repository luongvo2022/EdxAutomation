package selenium4.com.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static void unload() {
		extentTest.remove();
	}
}