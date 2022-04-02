package executeClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;

public class ExecuteManageOrder extends BaseClass {
	@Test
	public void verifyUserIsAbleToViewOrderDetails() {
		ManageOrderPage manageOrder = new ManageOrderPage(driver);
		LoginPage login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageOrderTab();
		manageOrder.clickViewButton();
		String ActualResult = manageOrder.titleOfNextPage();
		String expectedResult = manageOrder.getExpectedValue();
		Assert.assertEquals(ActualResult, expectedResult, expectedResult);

	}

	@Test(groups = "critical")
	public void verifyUserCanChangeDeliveryTime() {
		LoginPage login = new LoginPage(driver);
		ManageOrderPage manageOrder = new ManageOrderPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageOrderTab();
		manageOrder.clickChangeDeliveryAddressIcon();
		manageOrder.enterNewDeliveryTime(manageOrder.getTime());
		manageOrder.clickUpdateButton();
		String actualResult = manageOrder.getAttributeOfAlert();
		String expectedResult = manageOrder.getExpectedStatusResult();
		Assert.assertEquals(actualResult, expectedResult, "Delivery Time Not Changed");
	}

	@Test
	public void verifyErrorMessageforNoSearch() {
		LoginPage login = new LoginPage(driver);
		ManageOrderPage manageOrder = new ManageOrderPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageOrderTab();
		manageOrder.clickSearchButton();
		manageOrder.enterTextToBeSearched(manageOrder.getElementToBeSearched());
		manageOrder.clickSearchFinalButton();
		String actualResult = manageOrder.getTextErrorMessage();
		String expectedResult = manageOrder.getExpectedErrorMessage();
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(groups = "critical")
	public void verifyWorkingOfResetButton() {
		LoginPage login = new LoginPage(driver);
		ManageOrderPage manageOrder = new ManageOrderPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageOrderTab();
		manageOrder.clickSearchButton();
		manageOrder.clickResetButton();
		String actualResult = manageOrder.getHeadingResetPage();
		String expectedResult = manageOrder.getExpectedResult();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
