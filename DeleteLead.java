package firstpackage.week2.day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElementByXPath("//span[text()='Phone']").click();			
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("999999999");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);

		String Id = driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//a)[1]").getText();
		driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//a)[1]").click();
		Thread.sleep(2000);


		driver.findElementByLinkText("Delete").click();
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input").sendKeys(Id);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String isRecord=driver.findElementByXPath("//div[text()='No records to display']").getText();
		if(driver.findElementByXPath("//div[text()='No records to display']").getText().contains("No records to display")) {
			System.out.println("The "+Id+" Lead is deleted successfylly.");
			
			
		}
		
		driver.close();

	}

}
