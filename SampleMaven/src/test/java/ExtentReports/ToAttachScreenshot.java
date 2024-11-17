package ExtentReports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.logging.log4j.util.Timer.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ToAttachScreenshot {
	
	@Test
	public void addScreenshot() {
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		TakesScreenshot ts= (TakesScreenshot) driver;
		String photo=ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/screenshotreport"+time+".html");
		spark.config().setTheme(Theme.DARK);  //report theme can be setted using this syntax
		spark.config().setDocumentTitle("My Training Extent report");
		ExtentReports extReports= new ExtentReports();
		extReports.attachReporter(spark);
		ExtentTest test=extReports.createTest("addScreenshot");
		test.log(com.aventstack.extentreports.Status.PASS, "adding screenshot into report");
		test.addScreenCaptureFromBase64String(photo);
		extReports.flush();
	}

}
