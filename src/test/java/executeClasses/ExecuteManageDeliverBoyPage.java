package executeClasses;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;

public class ExecuteManageDeliverBoyPage extends BaseClass {
	LoginPage login;
	ManageDeliveryBoy manageDeliveryBoy;

	@Test
	public void verifyUserAbleToSearchASpecificDeliverBoy() {
		login = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoy(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageDeliveryBoy.clickManageDeliveryBoyTab();
		manageDeliveryBoy.clickSearchButton();
		manageDeliveryBoy.enterValueInNameFieldForSearch(manageDeliveryBoy.getElementToSearch());
		manageDeliveryBoy.clickSearchButtonAfterEnteringDetails();
		String actualResult = manageDeliveryBoy.getActualSearchedElement();
		String expectedResult = manageDeliveryBoy.getExpectedSearchElement();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyErrorMessageForNoMatch() {
		login = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoy(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageDeliveryBoy.clickManageDeliveryBoyTab();
		manageDeliveryBoy.clickSearchButton();
		manageDeliveryBoy.enterValueInNameFieldForSearch(manageDeliveryBoy.getValueToSearch());
		manageDeliveryBoy.clickSearchButtonAfterEnteringDetails();
		String actualResult = manageDeliveryBoy.getActualSearchedElement();
		String expectedResult = manageDeliveryBoy.getExpectedErrorMessage();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyUserIsAbleToChangeStatusOfDeliveryBoy() throws InterruptedException {
		login = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoy(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageDeliveryBoy.clickManageDeliveryBoyTab();
		manageDeliveryBoy.clickStatusIcon();
		Thread.sleep(3000);
		String actualResult = manageDeliveryBoy.getAttributeValueOfSuccessMessage(manageDeliveryBoy.getAttributeType());
		String expectedResult = manageDeliveryBoy.getExpectedAttributeValue();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
