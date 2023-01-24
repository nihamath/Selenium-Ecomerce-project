package SeleniumAutomation.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		String path= System.getProperty("user.dir")+"//report//spark.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Selenium Automation");
		System.out.println("created base report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nihamath");
		return extent;
	}

}
