package firstpackage.week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyRadioPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		//To select Yes radio button
		driver.findElementByXPath("//label[@for='yes']").click();
		System.out.println("The Yes radio button is selected successfully");
		
		//To find the default radio button selected
		if(driver.findElementByXPath("//label[@for='Checked']").getText().equalsIgnoreCase("checked")) {
			System.out.println("The CHECKED radio is selected by default");
		}
		
		//To select the age limit if not selected
		String isChecked = driver.findElementByXPath("//label[contains (text(), 'age group')]//following::input[2]").getAttribute("value");
		if (isChecked.equals("0")) {
			driver.findElementByXPath("//label[contains (text(), 'age group')]//following::input[2]").click();
		}
			
		else System.out.println("The age group is already selected");
		 
		
		
	}

}
