package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getSelectedValueFromDropDown(WebElement element, String valueToSelect) {
		Select select = new Select(element);
		select.selectByValue(valueToSelect);
		WebElement selectedValue = select.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}

	public Boolean checkboxIsSelected(WebElement element) {
		Boolean value = element.isSelected();
		return value;
	}

	public String getStyleProperties(WebElement element, String stylePropertyValue) {
		String fontSize = element.getCssValue(stylePropertyValue);
		return fontSize;
	}

	public String handleAlert(WebDriver driver) {

		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;

	}

	public String handleTooltip(WebElement element) {
		String toolTipValue = element.getAttribute("title");
		return toolTipValue;
	}

}
