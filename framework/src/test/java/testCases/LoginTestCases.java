package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginTestCases extends BaseClass {

	@Test
	public void verifyLoginWithValidUser() throws IOException {
		LoginPage lp = new LoginPage(driver);

		DashboardPage dp = lp.performLogin(ExcelReadUtility.getStringData(0, 0), ExcelReadUtility.getStringData(0, 1));

		String actual = dp.getTextFromHeading();
		String expected = "PAYROLL APPLICATION";
		Assert.assertEquals(actual, expected, "Login feature is not working");

	}

}
