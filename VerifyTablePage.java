package firstpackage.week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTablePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();

		//TO verify the rows count
		
		List<WebElement> Rows = driver.findElementsByTagName("tr");
		System.out.println("The no of rows= "+ Rows.size());
		
		//To verify the column count
		
		List<WebElement> Columns = driver.findElementsByTagName("th");
		System.out.println("The no of columns= "+ Columns.size());
		
		//To get the progress value of learn to interact with elements details
		
		String Progress = driver.findElementByXPath("//table[@id='table_id']//tr[3]/td[2]").getText();
		System.out.println("THe Progress value of Learn to Interact with Elements details is: "+Progress+".");
		
		//To select the checkbox
		
			
			driver.findElementByXPath("//table[@id='table_id']//tr[4]//input").click();
			if(driver.findElementByXPath("//table[@id='table_id']//tr[4]//input").isSelected()==true) {
			System.out.println("The Vital task check box for least progress is selected successfully");
			}
			else System.out.println("The vital task check box is not selected");
		
		
				
	}
}
