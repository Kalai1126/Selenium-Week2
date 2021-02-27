package firstpackage.week2.day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyImagePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		//TO verify the image click to home page
		driver.findElementByXPath("(//img[contains(@onclick,'home.html')])[1]").click();
		String verifyhomepage="http://leafground.com/home.html";
		String homepage = driver.getCurrentUrl();
		if(verifyhomepage.equals(homepage)) System.out.println("You clicked Home Page Image successfully and you are in  \""+ homepage + "\" Page.");

		driver.navigate().back();
		
		//To verify the Image is not enabled
		if (driver.findElementByXPath("//label[text()='Am I Broken Image?']/following-sibling::img").isSelected()==false) {
		System.out.println("The Image is not selectable and is broken");
		}
		
		//To verify the image click with the same click to home page image
		WebElement image = driver.findElementByXPath("(//img[contains(@onclick,'home.html')])[2]");
		String link = driver.findElementByXPath("(//img[contains(@onclick,'home.html')])[2]").getAttribute("onclick");
		image.sendKeys(link,Keys.ENTER);
		String repeatpage = driver.getCurrentUrl();
		if(verifyhomepage.equals(repeatpage)) System.out.println("You clicked repeated Home Page Image successfully and you are in  \""+ homepage + "\" Page.");
		
	}

}
