package jt;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static void main(String[] args) {
	
		
		ExtentReports extentreports = new ExtentReports();
		//String reportpath="reports/report.html";
		File file=new File("report.html");
		ExtentSparkReporter spark= new ExtentSparkReporter(file);
		extentreports.attachReporter(spark);
		ExtentTest test1= extentreports.createTest("Test 1");
		test1.pass("this is pass");
		
		ExtentTest test2= extentreports.createTest("Test 2");
		test2.log(Status.FAIL, "test2 is got failed");
		
		extentreports.createTest("Test 3")
		.log(Status.SKIP, "got skip")
		.log(Status.INFO, "<b>info</b>")
		.log(Status.FAIL, "<i>failed</i>")
		.addScreenCaptureFromBase64String(null);
		extentreports.flush();
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
