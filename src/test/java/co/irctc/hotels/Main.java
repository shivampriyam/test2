package co.irctc.hotels;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import co.irctc.hotels.driver.Driver;
import co.irctc.hotels.pages.BookingPage;
import co.irctc.hotels.pages.HotelHomePage;

public class Main {
	private static WebDriver driver;

	@Test
	public static void main() {
		driver = Driver.getDriver("ChromeDriver");
		driver.get("https://www.hotels.irctc.co.in/");
		new HotelHomePage(driver).verifyHomePage().selectCity("Bangalore");
		new BookingPage(driver).verifyBookingPage()
				.selectCheckInDate()
				.selectCheckOutDate()
				.selectRoomsAndGuests()
				.clickSearchHotelButton()
				.sortByPriceDescending()
				.sortByPriceAscending()
				.selectPriceRangeBySlider()
				.selectStarRating("3 Star")
				.selectStarRating("4 Star")
//				.selectUserRating("3+")
				;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
