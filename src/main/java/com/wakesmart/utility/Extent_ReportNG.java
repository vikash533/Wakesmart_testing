package com.wakesmart.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_ReportNG {
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"\\HTMLreports\\Automation_Test_Result.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Wake Smart Automation");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "OTS Solutions");
		return extent;
	}
}
