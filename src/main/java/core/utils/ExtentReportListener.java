package core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportListener implements ITestListener {


	public static File reportFile=null;
	static Logger LOG= LogManager.getLogger(ExtentReportListener.class);
	private static final  String OUTPUT_FOLDER="./reports/";
	private static final String FILE_NAME="extentlistenerreport.html";

	private static ExtentReports extent=init();
	public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
	public static ExtentReports extentReports;


	public static ExtentReports init() {


		Path path= Paths.get(OUTPUT_FOLDER);

		if(!Files.exists(path)) {

			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*
		 * SimpleDateFormat formeter=new SimpleDateFormat("dd-mm-yyyy"); //String
		 * Filename= String.format("repots/%s_", null)
		 */		
		extentReports = new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter(OUTPUT_FOLDER+FILE_NAME);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Orange HRM automation test results");
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("System", "Windows 10");
		extentReports.setSystemInfo("Author", "Ravi");
		extentReports.setSystemInfo("Teams", "goodyear");
		return extentReports;


	}


	public synchronized void onTestStart(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		String qualifiedName= result.getMethod().getQualifiedName();
		int last=qualifiedName.lastIndexOf(".");
		int mid=qualifiedName.substring(0, last).lastIndexOf(".");
		String className=qualifiedName.substring(mid+1, last);

		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
		LOG.info("Test Case Started : " + test.get().getModel().getName());

	}


	public void onTestSuccess(ITestResult result) {
	

		System.out.println(result.getMethod().getMethodName()+" passed");
		LOG.info("Test Passed: " +result.getMethod().getMethodName());
		test.get().pass("Test Passed: " +result.getMethod().getMethodName());
		test.get().getModel().setStartTime(getTime(result.getEndMillis()));

	}


	public void onTestFailure(ITestResult result) {
		
		
		test.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(Takescreenshot.takescreenshot(result.getName())).build());
		test.get().getModel().setStartTime(getTime(result.getEndMillis()));
		LOG.info("Test Failed: " +result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		
		test.get().skip(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(Takescreenshot.takescreenshot(result.getName())).build());
		test.get().getModel().setStartTime(getTime(result.getEndMillis()));
		LOG.info("Test Skiped: " +result.getMethod().getMethodName());
	}


	public void onStart(ITestContext context) {
		
		System.out.println("Test suite started");
	}


	public void onFinish(ITestContext context) {

		System.out.println("Test suit ended");
		extentReports.flush();
		
	}


	
   public Date getTime(Long millis) {
	   
	   
	   Calendar calender= Calendar.getInstance();
	   calender.setTimeInMillis(millis);
	   
	   return calender.getTime();
   }
   

}
