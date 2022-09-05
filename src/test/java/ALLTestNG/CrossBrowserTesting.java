package ALLTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	
static WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void GoogleChrome(String browser) {
		System.out.println("Testing as cross browser test");
		
		if(browser.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("User able to open Chrome Driver");
		
		}
		
		else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("User able to open Edge Driver");
		}
	}
	
	
		@Test
		public static void CrossBrowserTest() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/ref=nav_logo");
		
		}
		
		@AfterTest
		public void TearDown() {
		
			driver.manage().deleteAllCookies();
		    driver.quit();
		}

}
