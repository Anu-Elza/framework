package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;
	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement payrollApplicationheading;

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement worker;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement client;

	@FindBy(xpath = "//a[text()='TimeSheet']")
	WebElement timesheet;

	@FindBy(xpath = "//a[text()='Deduction']")
	WebElement deduction;

	public String getTextFromHeading() {

		return gu.getElementText(payrollApplicationheading);

	}

	public WorkerPage clickOnWorker() {
		worker.click();
		return new WorkerPage(driver);

	}

	public ClientPage clickOnClient() {

		client.click();
		return new ClientPage(driver);
	}

	public TimesheetPage clickOnTimesheet() {

		timesheet.click();
		return new TimesheetPage(driver);
	}

	public DeductionPage clickOnDeduction() {

		deduction.click();
		return new DeductionPage(driver);
	}
}
