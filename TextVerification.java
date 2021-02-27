package firstpackage.week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextVerification {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Login and verify the Interact with Edit Fields Page is loaded.		
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		String verifytitle="TestLeaf - Interact with Edit Fields";
		String title = driver.getTitle();
		if(verifytitle.equals(title)) System.out.println("You are in \""+ title + "\" Page.");
		
		//Enter your email address in the web element.
		driver.findElementById("email").sendKeys("kalaibala1126@gmail.com");
		
		//Verify the text is appended to the value in Append text box
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("Verify");
		System.out.println("The text Verify is appended successfully.");
		
		//Verify the default value entered in the Get default web element.
		WebElement defaultval = driver.findElementByName("username");
		String text = defaultval.getAttribute("value");
		if(text.equals("TestLeaf")) System.out.println("The expected default value \" TestLeaf \" is displayed in Get Default text field");
		
		//Verify the Clear Text.
		driver.findElementByXPath("//input[@value='Clear me!!']").clear();
		System.out.println("The text is cleared successfully from the text field.");
		
		//Verify the edit field is disabled.
		if(driver.findElementByXPath("//input[@disabled='true']").isEnabled()==false)System.out.println("The Text box is disabled as expected.");

		
		
		
		
	}
	
	
}
