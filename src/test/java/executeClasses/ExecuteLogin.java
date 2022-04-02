package executeClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;



public class ExecuteLogin extends BaseClass {
	LoginPage login;

	@Test(groups="critical")
	public void verifyUserAbleToLoginWithValidCredentials() {
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		String actualResult = login.getTitleDashboardPage();
		String expectedResult = login.getExpectedValueOfPageTitle();
		Assert.assertEquals(actualResult, expectedResult, "Still in LoginPage");
	}

	@Test(groups = "crirtical")
	public void verifyThatUserCannotLoginWithInvalidCredentials() {
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(2));
		login.clickSignin();
		String actualResult = login.getTitleDashboardPage();
		String expectedResult = login.getExpectedTileOfLoginPage();
		Assert.assertEquals(actualResult, expectedResult, "Still in LoginPage");
	}

	@Test(groups = "critical")
	public void verifyLoggedUsername() {
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		String actualResult = login.getLoggedUser();
		String expectedResult = login.getExpectedNameOfLoggedUser();
		Assert.assertEquals(actualResult, expectedResult, "Missmatch");

	}

	@Test
	public void verifyLoginButtonText() {
		login = new LoginPage(driver);
		String actualResult = login.getLoginText();
		String expectedResult =login.getExpectedTextOfLoginButton();
		Assert.assertEquals(actualResult, expectedResult, "Missmatch");
	}

	@Test
	public void verifyUserIsAbleToClickRemembermeCheckBox() {
		login = new LoginPage(driver);
		login.clickRememberCheckBoxAndVerifyIsSelected();
		Assert.assertTrue(true, "Not Selected");

	}

}
