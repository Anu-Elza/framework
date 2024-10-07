package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class WorkerPage {
	GeneralUtilities gu = new GeneralUtilities();

	public WorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorker;

	@FindBy(id = "worker-title")
	WebElement titleDropDown;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchLabel;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//span[@class='input-group-addon kv-date-calendar']")
	WebElement dobCalendar;

	public String selectValueFromTitleDropDown() {
		return gu.getSelectedValueFromDropDown(titleDropDown, "Mr");
	}

	public void clickCreateWorkerMenu() {
		createWorker.click();
	}

	public String getTextFromSearchButton() {

		return gu.getElementText(searchLabel);

	}

	public String getFontSizeOfSearchButton() {
		return gu.getStyleProperties(searchButton, "font-size");
	}

	public String handleTooltipInCreateWorkerSection() {
		return gu.handleTooltip(dobCalendar);
	}

}
