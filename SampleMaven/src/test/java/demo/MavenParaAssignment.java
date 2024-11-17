package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParaAssignment {
	@Test
	public void receiveData() {
		String url = System.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("Email")).sendKeys(System.getProperty("un"));
		driver.findElement(By.id("Password")).sendKeys(System.getProperty("pd"));
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Hp not loaded");
		Reporter.log("HP loaded",true);
		

}
}
