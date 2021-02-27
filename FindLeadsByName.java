package firstpackage.week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLeadsByName {
	
	public static void main(String[] args) throws InterruptedException {
		
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
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Kalaivani");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//a)[1]").click();

				
		String Title = driver.getCurrentUrl();
		System.out.println("The title of the Page is: "+Title);
		
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementByXPath("//input[@value='Update']").click();
		
		String UpdatedCompName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		if(UpdatedCompName.contains("TestLeaf")) {
			System.out.println("The Company is successfully updated to "+UpdatedCompName);
		}
		
		
		driver.close();
		
	}
	

}
