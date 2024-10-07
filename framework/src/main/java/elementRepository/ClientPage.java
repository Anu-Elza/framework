package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientPage {
	GeneralUtilities gu = new GeneralUtilities();

	public ClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Create Client']")
	WebElement createClientMenu;

	@FindBy(xpath = "//input[@id='client-require_po']")
	WebElement requirePocheckBox;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement resetButton;

	public void clickOnCreateClientMenu() {
		createClientMenu.click();
	}

	public void clickOnRequirePoCheckbox() {

		requirePocheckBox.click();
	}

	public Boolean selectCheckBox() {
		return gu.checkboxIsSelected(requirePocheckBox);
	}

	public String getFontSizeOfResetButton() {
		return gu.getStyleProperties(resetButton, "font-size");
	}
}
