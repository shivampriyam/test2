package co.irctc.hotels.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	protected WebDriver driver;
	protected FluentWait<WebDriver> wait;
	JavascriptExecutor jse;
	Actions actions;
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver)
						.ignoring(NoSuchElementException.class, WebDriverException.class)
						.withTimeout(Duration.ofSeconds(20))
						.pollingEvery(Duration.ofMillis(200));
		PageFactory.initElements(driver, this);
		jse = (JavascriptExecutor)driver;
		actions = new Actions(driver);
	}
	public void ThreadSleep(long timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
