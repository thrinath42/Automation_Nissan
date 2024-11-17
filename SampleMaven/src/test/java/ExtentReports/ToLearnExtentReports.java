package ExtentReports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {

	@Test
	public void report() {
		String timestamp= LocalDateTime.now().toString().replace(":", "-");
		//Step1:- create an instance of extentsparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/extentReport"+timestamp+".html");
		
		//step2:- create an instance of Extent Reports
		ExtentReports extReport=new ExtentReports();
		
		//step3:- attach an instance of ExtentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		//step4:- create an instance of ExtentTest
		ExtentTest test = extReport.createTest("Report");
		
		//step5:- call log() to provide status and log message
		test.log(Status.PASS, "log message added into report");
		test.log(Status.PASS, "open browser");
		
		//step6:-call flush() to write messages into destination
		extReport.flush();
	}
}
