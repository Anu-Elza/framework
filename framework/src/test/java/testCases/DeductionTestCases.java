package testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.DeductionPage;
import elementRepository.LoginPage;
import elementRepository.TimesheetPage;
import utilities.ExcelReadUtility;

public class DeductionTestCases extends BaseClass {
	@Test
	public void verifyTooltipFromAddDeductionSection() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));
		DeductionPage dp1 = dp.clickOnDeduction();
		dp1.clickOnAddDeductionMenu();
		dp1.handleTooltipInAddDeductionSection();

		String actualResult = dp1.handleTooltipInAddDeductionSection();
		String expectedResult = "Select date";
		Assert.assertEquals(actualResult, expectedResult, "Tooltip is not present in Add Deduction Section");// soft
																												// assertion
	}

}
