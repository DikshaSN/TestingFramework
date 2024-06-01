package TestingFramework.Resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {

	public static ExtentReports getReportObject() {
		String path ="D:\\Selenium\\Scripts\\TestingFramework\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestingFramework");
		reporter.config().setReportName("TestingFramework");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "DikshaKamdi");
		return extent;
	}
}
