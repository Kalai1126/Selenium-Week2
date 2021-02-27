package firstpackage.week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Cognizant Technology Solutions");
		driver.findElementById("createLeadForm_firstName").sendKeys("Kalaivani");
		driver.findElementById("createLeadForm_lastName").sendKeys("Balasubramanian");
		WebElement source = driver.findElementByName("dataSourceId");
		Select dropdown = new Select(source);
	    dropdown.selectByVisibleText("Employee");
		WebElement campaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdown1 = new Select(campaign);
	    dropdown1.selectByValue("9001");
		WebElement original = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropdown2 = new Select(original);
	    dropdown2.selectByIndex(5);
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdown3 = new Select(country);
	    dropdown3.selectByVisibleText("India");
		driver.findElementByName("submitButton").click();
		String LeadPage = driver.getTitle();
		System.out.println("Hey I am in LeadPage: "+LeadPage);
				
	}
}
