package hotwire.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

import hotwire.pages.Homepage;
import hotwire.pages.SearchResultPage;
import hotwire.pages.VacationsPage;
import hotwire.util.BaseTest;
import hotwire.validations.validateVacations;

public class BookingFlightTests extends BaseTest {
	
	public static Homepage home = new Homepage();
	public static VacationsPage vacation = new VacationsPage();
	public static SearchResultPage search = new SearchResultPage();
	
	public static validateVacations validate = new validateVacations();
	
	@Test(priority=1, description = "validate package booking results")
	 public void testPackageBooking()  {
		
		//Navigate to Vacations page
		home.navigateVacationsPage();
		
		//Fill out details in vacations page
		vacation.selectPackage("all");
		vacation.enterLocations("SFO", "LAX");
		
		
		//date selection math & enter
		String strtDate = getDesiredDate(1); //currentdate + 1
		String endDate = getDesiredDate(22); //currentdate + 22 (considering 3 weeks as 21 days)
		vacation.selectDates(strtDate, endDate);

		//Enter Time and Submit
		vacation.selectTime("Evening", "Morning");
		vacation.submitPage();
		
		
		//Validating there are more than 0 results
		Assert.assertTrue(validate.validateSearchResult(search.countofresultGrid()));
	}
	

}
