package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenParameterTest {
	
	@Test
	public void receiveData() {
		String url = System.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		System.out.println(System.getProperty("un"));
		System.out.println(System.getProperty("pwd"));
		
		
	}

}
