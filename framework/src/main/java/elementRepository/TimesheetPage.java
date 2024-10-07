package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class TimesheetPage {
	GeneralUtilities gu = new GeneralUtilities();

	public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//button[text()='Generate Invoice']")
	WebElement generateInvoice;

	public void clickOnGenerateInvoiceMenu() {
		generateInvoice.click();
	}

	public String handleAlertInGenerateInvoiceSection() {
		return gu.handleAlert(driver);
	}

	public String getTextFromGenerateInvoiceButton() {

		return gu.getElementText(generateInvoice);

	}

}
