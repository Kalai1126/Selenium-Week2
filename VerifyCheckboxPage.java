package firstpackage.week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyCheckboxPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		//Verify the checkbox Java and SQL is selected and C is selected and deselected
		 driver.findElementByXPath("//label[text()='Select the languages that you know?']/following::input").click();
		 driver.findElementByXPath("(//label[text()='Select the languages that you know?']/following::input)[3]").click();
		 driver.findElementByXPath("(//label[text()='Select the languages that you know?']/following::input)[5]").click();
		 driver.findElementByXPath("(//label[text()='Select the languages that you know?']/following::input)[5]").click();

		 //To Verify the checkBox is selected by default
		 if(driver.findElementByXPath("//label[text()='Confirm Selenium is checked']/following::input").isSelected()==true)System.out.println("The Selenium checkbox is selected by default.");
		 
		 //To uncheck the default checked one
		 if(driver.findElementByXPath("//label[text()='DeSelect only checked']/following::input").isSelected()==true){		 
		 
		 driver.findElementByXPath("//label[text()='DeSelect only checked']/following::input").click();
		 System.out.println("The 'Not Selected' check box is  checked by default and hence dechecked by script");
		 }
		 
		 else if (driver.findElementByXPath("(//label[text()='DeSelect only checked']/following::input)[2]").isSelected()==true){		 
			 
			 driver.findElementByXPath("(//label[text()='DeSelect only checked']/following::input)[2]").click();
			 System.out.println("The 'I am Selected' check box is  checked by default and hence dechecked by script.");
			 
		 }
		 else System.out.println("No checkboxes are selected by default");		
		 
		 // To select all the check Box options
		List<WebElement> checkBoxList=driver.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input");
		
		//for(int i = 0; i<checkBoxList.size();i++) {
			//List<WebElement> optionValue =driver.findElementsByXPath("(//label[text()='Select all below checkboxes ']/following::div)[i]").subList(0, i);
		//}
		

		for (WebElement checkBox : checkBoxList) {
			
			checkBox.click();
			//optionValue.get(2).getText();
			System.out.println("The "+checkBox.getText()+" is selected successfully.");
		}
		
	}
}

