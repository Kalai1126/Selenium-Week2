package firstpackage.week2.day1;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOpera {

	public static void main(String[] args) {
		WebDriverManager.operadriver().setup();
		OperaDriver driver = new OperaDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String 	name = driver.getTitle();	
		System.out.println(name);
	}
}
