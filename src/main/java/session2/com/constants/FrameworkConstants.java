package session2.com.constants;

import session2.com.helpers.Helpers;
import session2.com.helpers.PropertiesHelpers;
//import session4.com.utils.ReportUtils;

import java.io.File;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	static {
		PropertiesHelpers.loadAllFiles();
		System.out.println("Data From FrameworkConstants: " + PropertiesHelpers.getProperties());
	}

	public static final String PROJECT_PATH = Helpers.getCurrentDir();
	// public static final String EXCEL_DATA_FILE_PATH =
	// PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");
	// public static final String JSON_DATA_FILE_PATH =
	// PropertiesHelpers.getValue("JSON_DATA_FILE_PATH");

	public static final String BROWSER =  PropertiesHelpers.getValue("BROWSER");
//	public static final String BROWSER =  System.getProperty("BROWSER");
	public static final String REMOTE_URL = PropertiesHelpers.getValue("REMOTE_URL");
	public static final String REMOTE_PORT = PropertiesHelpers.getValue("REMOTE_PORT");
	public static final String COURSE_URL= PropertiesHelpers.getValue("COURSE_URL");
	// public static final String PROJECT_NAME =
	// PropertiesHelpers.getValue("PROJECT_NAME");
	// public static final String REPORT_TITLE =
	// PropertiesHelpers.getValue("REPORT_TITLE");
	// public static final String EXTENT_REPORT_NAME =
	// PropertiesHelpers.getValue("EXTENT_REPORT_NAME");
	// public static final String EXTENT_REPORT_FOLDER =
	// PropertiesHelpers.getValue("EXTENT_REPORT_FOLDER");
	// public static final String EXPORT_VIDEO_PATH =
	// PropertiesHelpers.getValue("EXPORT_VIDEO_PATH");
	// public static final String EXPORT_CAPTURE_PATH =
	// PropertiesHelpers.getValue("EXPORT_CAPTURE_PATH");
	public static final String SEND_REPORT_TO_TELEGRAM = PropertiesHelpers.getValue("SEND_REPORT_TO_TELEGRAM");
	public static final String TELEGRAM_TOKEN = PropertiesHelpers.getValue("TELEGRAM_TOKEN");
	public static final String TELEGRAM_CHATID = PropertiesHelpers.getValue("TELEGRAM_CHATID");
	// public static final String AUTHOR = PropertiesHelpers.getValue("AUTHOR");
	public static final String TARGET = PropertiesHelpers.getValue("TARGET");
	public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
	public static final String OVERRIDE_REPORTS = PropertiesHelpers.getValue("OVERRIDE_REPORTS");
	public static final String OPEN_REPORTS_AFTER_EXECUTION = PropertiesHelpers.getValue("OPEN_REPORTS_AFTER_EXECUTION");
	public static final String SEND_EMAIL_TO_USERS = PropertiesHelpers.getValue("SEND_EMAIL_TO_USERS");
	public static final String SCREENSHOT_PASSED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_PASSED_STEPS");
	public static final String SCREENSHOT_FAILED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_FAILED_STEPS");
	public static final String SCREENSHOT_SKIPPED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_SKIPPED_STEPS");
	public static final String SCREENSHOT_ALL_STEPS = PropertiesHelpers.getValue("SCREENSHOT_ALL_STEPS");
	public static final String ZIP_FOLDER = PropertiesHelpers.getValue("ZIP_FOLDER");
	public static final String ZIP_FOLDER_PATH = PropertiesHelpers.getValue("ZIP_FOLDER_PATH");
	public static final String ZIP_FOLDER_NAME = PropertiesHelpers.getValue("ZIP_FOLDER_NAME");

	public static final String LOCATE = PropertiesHelpers.getValue("LOCATE");
	public static final String RETRY_TEST_FAIL = PropertiesHelpers.getValue("RETRY_TEST_FAIL");

	public static final int WAIT_DEFAULT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_DEFAULT"));
	public static final int WAIT_IMPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_IMPLICIT"));
	public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
	public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
	public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
	public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");

	// public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH +
	// EXTENT_REPORT_FOLDER;
	// public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME +
	// ".html";
	// public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH +
	// File.separator + EXTENT_REPORT_FILE_NAME;

	// Zip file for Report folder
	// public static final String ZIPPED_EXTENT_REPORTS_FOLDER =
	// EXTENT_REPORT_FOLDER + ".zip";

	public static final String YES = "yes";
	public static final String NO = "no";

	public static final String BOLD_START = "<b>";
	public static final String BOLD_END = "</b>";
}
