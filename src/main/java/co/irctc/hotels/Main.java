package co.irctc.hotels;

import org.openqa.selenium.WebDriver;

import co.irctc.hotels.driver.Driver;

public class Main {
	private static WebDriver driver;

	public static void main(String[] args) {
		driver = Driver.getDriver("ChromeDriver");
		driver.get("https://www.hotels.irctc.co.in/");
		
		driver.quit();
	}

}
