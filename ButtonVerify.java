package firstpackage.week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonVerify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		String verifytitle="TestLeaf - Interact with Buttons";
		String title = driver.getTitle();
		if(verifytitle.equals(title)) System.out.println("You are in \""+ title + "\" Page.");
		
		//Verify the click action on go to home page button
		driver.findElementById("home").click();
		String verifyhomepage="TestLeaf - Selenium Playground";
		String homepage = driver.getTitle();
		if(verifyhomepage.equals(homepage)) System.out.println("You clicked Home Page button and you are in  \""+ homepage + "\" Page.");
		
		driver.navigate().back();
		System.out.println("You navigated back to TestLeaf - Interact with Buttons");
		
		//Verify the Get position button
		System.out.println("The position of the button is: "+driver.findElementById("position").getLocation());
		
		//Verify the button color:		
		System.out.println("The color of the button is: "+driver.findElementById("color").getCssValue("background-color"));

		//Verify the size of the button.
		System.out.println("The size of the button is: "+driver.findElementById("size").getSize());
		
	}

}
