package firstpackage.week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginACMESys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementByClassName("btn").click();
		String HomePage = driver.getTitle();
		System.out.println("Hey I am in HomePage: "+HomePage);
		driver.findElementByLinkText("Log Out").click();
		System.out.println("Logged out successfully");
		driver.close();
		System.out.println("Browser closed successfully");


	}

}
