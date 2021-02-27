package firstpackage.week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadCreation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		String HomePage = driver.getTitle();
		System.out.println("Hey I am in HomePage: "+HomePage);
		
		driver.findElementByXPath("//img[@src='/opentaps_images/integratingweb/crm.png']").click();
		driver.findElementByLinkText("Leads").click();
	
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Email']").click();			
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("kalai.bala@Test.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);


		String name = driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-firstName ')]//a)[1]").getText();
		driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-firstName ')]//a)[1]").click();
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Duplicate Lead").click();
		Thread.sleep(5000);
		
		driver.findElementByClassName("smallSubmit").click();
		
		if(driver.findElementByXPath("//span[text()='kalai1']").getText().equalsIgnoreCase(name)) {
			System.out.println("The Lead with name "+name+" is duplicated successfully.");
		}
		

		
		


	}

}
