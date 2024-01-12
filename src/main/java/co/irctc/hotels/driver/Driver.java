package co.irctc.hotels.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("ChromeDriver"))
			driver = new ChromeDriver();
		else
			driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	
}
