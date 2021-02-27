package firstpackage.week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDropdownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//To select the program using SelectByIndex()
		WebElement source = driver.findElementById("dropdown1");
		Select dropdown1 = new Select(source);
		dropdown1.selectByIndex(1);
		
		//To select the program using SelectByVisibleText()
		WebElement source1 = driver.findElementByName("dropdown2");
		Select dropdown2 = new Select(source1);
		dropdown2.selectByVisibleText("Appium");
		
		//To select the program using SelectByValue()
		WebElement source2 = driver.findElementById("dropdown3");
		Select dropdown3 = new Select(source2);
		dropdown3.selectByValue("3");
		
		//To get the number of dropdowns in the page
		List<WebElement> dropdowns = driver.findElementsByTagName("Select");
		int TotDropdown=dropdowns.size()-1;
		System.out.println("The Total drop down in the webpage is: "+TotDropdown);
		
		//To select the value through sendkeys from drop down
		driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[5]/select[1]").sendKeys("L");
		
		//To select multiple programs from the selectlist
		WebElement source3 = driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[6]/select[1]");
		Select multiselect = new Select(source3);
		multiselect.selectByVisibleText("Selenium");
		multiselect.selectByIndex(0);
		multiselect.selectByVisibleText("UFT/QTP");
		multiselect.selectByValue("4");
		multiselect.deselectByIndex(4);


		

		

		
	}

}
