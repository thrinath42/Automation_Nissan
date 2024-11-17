package ExtentReports;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoWebShopAssignment {
	
	@Test
	public void addScreenshot() {
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");

		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/DWSA"+time+".html");
		spark.config().setDocumentTitle("My Assigment");
		ExtentReports extReports= new ExtentReports();
		extReports.attachReporter(spark);
		
		ExtentTest test=extReports.createTest("Welcome Page");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "WelcomePage not loaded");
		test.log(com.aventstack.extentreports.Status.PASS, "Welcome Page loaded");
		
		driver.findElement(By.partialLinkText("Log in")).click();
		ExtentTest test1=extReports.createTest("Login Page");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login", "Lp not loaded");
		test1.log(com.aventstack.extentreports.Status.PASS, "Login Page loaded");
		
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		ExtentTest test2=extReports.createTest("Home Page");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Hp not loaded");
		test2.log(com.aventstack.extentreports.Status.PASS, "Home Page loaded");
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		String photo=ts.getScreenshotAs(OutputType.BASE64);
		test2.addScreenCaptureFromBase64String(photo);
		extReports.flush();
		
		
		
		;
		
		
		
	}
}
