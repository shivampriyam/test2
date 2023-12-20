package co.irctc.hotels.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {

	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("ChromeDriver"))
			return new ChromeDriver();
		else
			return new EdgeDriver();
	}

	
}
