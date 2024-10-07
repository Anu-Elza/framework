package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.DeductionPage;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelReadUtility;

public class WorkerTestCases extends BaseClass {
	@Test(retryAnalyzer = retryAnalyser.RetryAnalyser.class)
	public void verifyTitleFromDropdown() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		WorkerPage wp = dp.clickOnWorker();
		wp.clickCreateWorkerMenu();
		String actualResult = wp.selectValueFromTitleDropDown();
		String expectedResult = "Mr";

		SoftAssert sample = new SoftAssert();
		sample.assertEquals(actualResult, expectedResult, "Value is not selected from dropdown");// soft assertion
		sample.assertAll();
	}

	@Test(groups = "critical")
	public void verifyTextOfSearchButtonInWorkersPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		WorkerPage wp = dp.clickOnWorker();
		String actualResult = wp.getTextFromSearchButton();
		String expectedResult = "Search";

		SoftAssert sample = new SoftAssert();
		sample.assertEquals(actualResult, expectedResult, "Search button text not found");// soft assertion
		sample.assertAll();
	}

	@Test(groups = "critical")
	public void verifyFontSizeOfSerachButton() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		WorkerPage wp = dp.clickOnWorker();
		String actualResult = wp.getFontSizeOfSearchButton();
		String expectedResult = "14px";

		SoftAssert sample = new SoftAssert();
		sample.assertEquals(actualResult, expectedResult, "Search button font size incorrect");// soft assertion
		sample.assertAll();
	}

	public void verifyTooltipFromDobCalendarOfCreateWorkerSection() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		WorkerPage wp = dp.clickOnWorker();
		wp.clickCreateWorkerMenu();
		wp.handleTooltipInCreateWorkerSection();
		String actualResult = wp.handleTooltipInCreateWorkerSection();
		String expectedResult = "Select date";
		Assert.assertEquals(actualResult, expectedResult, "Tooltip is not present in Create Worker Section");// soft
																												// assertion
	}

}
