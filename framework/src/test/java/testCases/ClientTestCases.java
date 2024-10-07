package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import constant.Constant;
import elementRepository.ClientPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelReadUtility;

public class ClientTestCases extends BaseClass {
	@Test
	public void verifyCheckboxFromClientMenu() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		ClientPage cp = dp.clickOnClient();
		cp.clickOnCreateClientMenu();
		cp.clickOnRequirePoCheckbox();

		Boolean actualResult = cp.selectCheckBox();
		Boolean expectedResult = true;

		SoftAssert sample = new SoftAssert();
		sample.assertEquals(actualResult, expectedResult, Constant.errorMessageCheckBox);// soft assertion
		sample.assertAll();
	}

	@Test
	public void verifyFontSizeOfResetButton() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		ClientPage cp = dp.clickOnClient();
		String actualResult = cp.getFontSizeOfResetButton();
		String expectedResult = "14px";

		SoftAssert sample = new SoftAssert();
		sample.assertEquals(actualResult, expectedResult, "Reset button font size incorrect");// soft assertion
		sample.assertAll();
	}

}
