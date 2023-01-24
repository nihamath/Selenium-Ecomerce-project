package SeleniumAutomation.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumAutomation.Utils.ExtentReporterNG;

public class TestListener extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult iTestResult) {
		
		test= extent.createTest(iTestResult.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("onstart");
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		extent.flush();
	}



	@Override
	public void onTestSuccess(ITestResult iTestResult) {

		test.log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		test.fail(iTestResult.getThrowable());
		
		String filePath = null;
		try {
			driver = (WebDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			filePath = captureScreen(iTestResult.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath,iTestResult.getMethod().getMethodName());

	}

	

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}
}
