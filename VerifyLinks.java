
package firstpackage.week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html#");
		driver.manage().window().maximize();
		
		//Go to Home Page Link Validation
		
		driver.findElementByLinkText("Go to Home Page").click();
		String verifyhomepage="TestLeaf - Selenium Playground";
		String homepage = driver.getTitle();
		if(verifyhomepage.equals(homepage)) System.out.println("You clicked Home Page Link successfully and you are in  \""+ homepage + "\" Page.");

		driver.navigate().back();
		
		//Find the link reference page
		
		String LinkNavigation = driver.findElementByXPath("//a[@href='Button.html']").getAttribute("href");
		System.out.println("The link navigates to "+ LinkNavigation+" Page.");
		
		//Verify the link navigates to error page
		driver.findElementByLinkText("Verify am I broken?").click();
		String verifyerrorpage = driver.getTitle();
		if(verifyerrorpage.equals("HTTP Status 404 – Not Found")) System.out.println("Error Page is displayed");
		
		driver.navigate().back();
		
		//Verify the link with the same name is clicked correctly
		
		driver.findElementByXPath("(//a[@link='blue'])[3]").click();
		String repeatpage = driver.getTitle();
		if(verifyhomepage.equals(repeatpage)) System.out.println("You clicked Home Page Link with the same name  successfully and you are in  \""+ repeatpage + "\" Page.");

		driver.navigate().back();

		//Verify the total number of links in the page
	      //ArrayList<WebElement> links = (ArrayList<WebElement>) driver.findElementsByTagName("a");
		  List<WebElement> links = driver.findElementsByTagName("a");
	      int Totlink = links.size()-1;
	      System.out.println("The no. of links in the web page is: "+Totlink);
	}

}
