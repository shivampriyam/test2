package co.irctc.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HotelHomePage extends BasePage{
	@FindBy(xpath = "/html/body/app-root/app-home/div[2]/div[2]/div/div/div[2]/h2/a")
	private List<WebElement> cities;

	public HotelHomePage(WebDriver driver) {
		super(driver);
	}
	
	public HotelHomePage verifyHomePage() {
		Assert.assertEquals("IRCTC Hotels", driver.getTitle(), "Irctc Hotel Home Page Not Verified");
		return this;
	}
	
	public HotelHomePage selectCity(String city) {
//		cities = driver.findElements(By.xpath("/html/body/app-root/app-home/div[2]/div[2]/div/div/div[2]/h2/a"));
		for(WebElement elem: cities) {
			if(elem.getText().equalsIgnoreCase(city)) {
				jse.executeScript("arguments[0].scrollIntoView(true);", elem);
				ThreadSleep(400);
				elem.click();
				break;
			}
		}
		return this;
	}

}
