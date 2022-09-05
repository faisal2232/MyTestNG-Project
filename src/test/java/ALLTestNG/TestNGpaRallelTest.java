package ALLTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGpaRallelTest {
	
	@Test
	public static void chromeOne() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Get My Chrome Thread Count :" + " " + Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/ref=nav_logo");
		
		TestNGclaSS_A.getMyPayment();
		TestNGclaSS_A.getMyDelivery();
		TestNGclaSS_B.getMyShipping();
		TestNGclaSS_B.getMyLabel();
		
		System.out.println("Total test cases 4");
	}
	
	@Test
	public static void chrome2() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Get My Chrome Thread Count :" + " " + Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/ref=nav_logo");
		
		TestNGclaSS_C.getCart();
		TestNGclaSS_C.getMyReturn();
		TestNGclaSS_C.getShoppingBag();
		
		System.out.println("Total test cases 3");
		
	}

}
