package co.irctc.hotels.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BookingPage extends BasePage{
	@FindBy(name = "dt12") private WebElement checkInDate;
	@FindBy(name = "dt13") private WebElement checkOutDate;
//	private String datePickerInitByXapth = "//*[@id=\"owl-dt-picker-2\"]/div[2]/owl-date-time-calendar/div[1]/div/button/span";
	private String datePickerInitByXapth = "//owl-date-time-calendar/div[1]/div/button/span";
	private String yearsGridByClassName = "owl-dt-calendar-body";
	@FindBy(id = "user-data-wrapper-id") private WebElement roomsAndGuests;
	private String roomsLocatorByName = "hotelRoom";
	private String adultsLocatorByName = "hotelAdult";
	private String childLocatorByName = "hotelChild";
	private String buttonRoomsAndGuestByClassName = "introDefault";
	private String buttonSearchHotelByXpath = "/html/body/app-root/app-hotellist/div[1]/div/div/app-hotelmodify/form/div[5]/button";
	private String sortLocatorByName = "/html/body/app-root/app-hotellist/div[2]/div/div/div[3]/div[1]/div/a[2]";
	private String leftSliderLocatorByXpath = "//*[@id=\"slider-range\"]/span[1]";
	private String rightSliderLocatorByXpath = "//*[@id=\"slider-range\"]/span[2]";

	public BookingPage(WebDriver driver) {
		super(driver);
	}
	
	public BookingPage verifyBookingPage() {
		wait.until(new Function<WebDriver, Object>() {
			public Object apply(WebDriver driver) {
				boolean pageLoaded = driver.findElements(By.name("dt12")).size() > 0;
				PageFactory.initElements(driver, this);
				return pageLoaded;
			}
		});
		return this;
	}
	
	public BookingPage selectCheckInDate() {
		SelectDate(checkInDate, "12/Dec/2024");
		return this;
	}

	public BookingPage selectCheckOutDate() {
		SelectDate(checkOutDate, "13/Dec/2024");
		return this;
	}
	
	public BookingPage selectRoomsAndGuests() {
		roomsAndGuests.click();
		SelectRoomsAndGuests(roomsLocatorByName, "3");
		SelectRoomsAndGuests(adultsLocatorByName, "3");
		SelectRoomsAndGuests(childLocatorByName, "0");
		driver.findElement(By.className(buttonRoomsAndGuestByClassName )).click();
		return this;
	}

	public BookingPage clickSearchHotelButton() {
		driver.findElement(By.xpath(buttonSearchHotelByXpath)).click();
		return this;
	}
	
	public BookingPage sortByPriceDescending() {
		wait.until(new Function<WebDriver, Object>() {
			public Object apply(WebDriver driver) {
				boolean pageLoaded = driver.findElements(By.className("filtersearch-packages")).size() > 0;
				return pageLoaded;
			}
		});
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sortLocatorByName )));
		driver.findElement(By.xpath(sortLocatorByName)).click();
		return this;
	}
	
	public BookingPage sortByPriceAscending() {
		driver.findElement(By.xpath(sortLocatorByName)).click();
		return this;
	}
	
	public BookingPage selectPriceRangeBySlider() {
		WebElement sliderLeft = driver.findElement(By.xpath(leftSliderLocatorByXpath ));
		WebElement sliderRight = driver.findElement(By.xpath(rightSliderLocatorByXpath ));
		
//		System.out.println("Left: "+sliderLeft.getLocation() +"_Right"+ sliderRight.getLocation());
		actions.clickAndHold(sliderLeft).moveByOffset(100, 0).release(sliderLeft).build().perform();
		actions.clickAndHold(sliderRight).moveByOffset(-100, 0).release(sliderRight).build().perform();
//		System.out.println("Left: "+sliderLeft.getLocation() +"_Right"+ sliderRight.getLocation());
		return this;
	}
	
	public BookingPage selectStarRating(String starRating) {
		if(starRating.equalsIgnoreCase("5 Star"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[4]/ul/li[1]/label")).click();
		else if(starRating.equalsIgnoreCase("4 Star"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[4]/ul/li[2]/label")).click();
		else if(starRating.equalsIgnoreCase("3 Star"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[4]/ul/li[3]/label")).click();
		else if(starRating.equalsIgnoreCase("Below 3 Star"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[4]/ul/li[4]/label")).click();
		return this;
	}
	
	public BookingPage selectUserRating(String userRating) {
		if(userRating.equalsIgnoreCase("4.5+"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[5]/ul/li[1]/label")).click();
		else if(userRating.equalsIgnoreCase("4+"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[5]/ul/li[2]/label")).click();
		else if(userRating.equalsIgnoreCase("3+"))
			driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/div[5]/ul/li[3]/label")).click();
		
		ThreadSleep(1000);
		return this;
	}

	
	private void SelectDate(WebElement checkInDate2, String string) {
		String date[] = string.split("/");
//		jse.executeScript("arguments[0].scrollIntoView(true);", checkInDate2);
		ThreadSleep(1000);
		checkInDate2.click();
		driver.findElement(By.xpath(datePickerInitByXapth )).click();
		ThreadSleep(1000);
		List<WebElement> yearList = driver.findElement(By.className(yearsGridByClassName )).findElements(By.tagName("td"));
		for(WebElement elem: yearList) {
//			wait.until(null)
			if(Integer.parseInt(elem.getText()) == Integer.parseInt(date[2])) {
				elem.click();
				break;
			}
		}
		
		List<WebElement> monthList = driver.findElement(By.className(yearsGridByClassName )).findElements(By.tagName("td"));
		for(WebElement elem: monthList) {
			if(elem.getText().equalsIgnoreCase(date[1])) {
				elem.click();
				break;
			}
		}
		
		List<WebElement> dateList = driver.findElement(By.className(yearsGridByClassName )).findElements(By.tagName("td"));
		for(WebElement elem: dateList) {
			if(Integer.parseInt(elem.getText()) == Integer.parseInt(date[0])) {
				elem.click();
				break;
			}
		}
	}
	
	private void SelectRoomsAndGuests(String SelectLocator, String i) {
		Select select = new Select(driver.findElement(By.name(SelectLocator)));
		select.selectByVisibleText(i);
	}
}
