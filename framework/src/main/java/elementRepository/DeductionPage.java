package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DeductionPage {
	GeneralUtilities gu = new GeneralUtilities();

	public DeductionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Add Deduction']")
	WebElement addDeduction;

	@FindBy(xpath = "//span[@class='input-group-addon kv-date-calendar']")
	WebElement calendar;

	public void clickOnAddDeductionMenu() {
		addDeduction.click();
	}

	public String handleTooltipInAddDeductionSection() {
		return gu.handleTooltip(calendar);
	}
}
