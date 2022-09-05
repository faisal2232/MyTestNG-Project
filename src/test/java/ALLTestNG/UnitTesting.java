package ALLTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitTesting {
	
	WebDriver driver;
	
	@BeforeTest
	public void getMySetUp() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Get My Chrome Thread Count :" + " " + Thread.currentThread().getId());
		driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Browser is open");
		
	}
	
	@Test
	public void getMyFunctionSetOne() {
		driver.findElement(By.xpath("//*[@id='__next']/div/header/div/div/nav/div[3]/div[2]/ul/li[3]/a")).click();
		System.out.println("My Test Case 1");
	}

	
	@AfterTest
	public void tearDown() {
		System.out.println("Driver is close");
		driver.manage().deleteAllCookies();
		driver.quit();
		
	}
}
