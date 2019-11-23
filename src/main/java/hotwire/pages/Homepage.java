package hotwire.pages;

import org.openqa.selenium.By;

import hotwire.util.BaseTest;

public class Homepage extends BaseTest {
	
	private By menuVacations = By.xpath("//a[text()='Vacations']");
	
	
	public void navigateVacationsPage() {
		getElement(menuVacations, 5).click();
	}

}
