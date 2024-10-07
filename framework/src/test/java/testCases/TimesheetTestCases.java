package testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import elementRepository.ClientPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.TimesheetPage;
import utilities.ExcelReadUtility;

public class TimesheetTestCases extends BaseClass {
	@Test
	public void verifyAlertMessageFromGenerateInvoiceSection() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		TimesheetPage tp = dp.clickOnTimesheet();
		tp.clickOnGenerateInvoiceMenu();
		String actualResult = tp.handleAlertInGenerateInvoiceSection();
		String expectedResult = "Are you sure you want to generate invoice?";
		Assert.assertEquals(actualResult, expectedResult, "Alert not handled in invoice section");// soft assertion
	}

	@Test
	public void verifyTextOfGenerateInvoiceButton() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		TimesheetPage tp = dp.clickOnTimesheet();
		String actualResult = tp.getTextFromGenerateInvoiceButton();
		String expectedResult = "Generate Invoice";
		Assert.assertEquals(actualResult, expectedResult, "Generate Invoice text doesn't match");

	}
}
