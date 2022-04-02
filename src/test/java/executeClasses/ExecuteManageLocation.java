package executeClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;

public class ExecuteManageLocation extends BaseClass {
	LoginPage login;
	ManageLocationPage manageLocation;

	@Test
	public void verifyErrorMessageForNoMatch() {
		login = new LoginPage(driver);
		manageLocation = new ManageLocationPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageLocation.clickManageLocationTab();
		manageLocation.clickFirstSearchButton();
		manageLocation.selectCountry(manageLocation.getCountryName());
		manageLocation.selectState(manageLocation.getStateName());
		manageLocation.enterLocation(manageLocation.getStreetName());
		manageLocation.clickSearchButtonAfterEnteringValue();
		String actualResult = manageLocation.getTextOfErrorMessageIfNoMatch();
		String expectedResult = manageLocation.getErrorMessageForNoSearch();
		Assert.assertEquals(actualResult, expectedResult, "Missmatch");
	}

	@Test
	public void verifyUserAbleToSearchLocationWithCountryName() {
		login = new LoginPage(driver);
		manageLocation = new ManageLocationPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageLocation.clickManageLocationTab();
		manageLocation.clickFirstSearchButton();
		manageLocation.selectCountry(manageLocation.getCountryName());
		manageLocation.selectState(manageLocation.getStateNameForSearch());
		manageLocation.enterLocation("East Sussex");
		manageLocation.clickSearchButtonAfterEnteringValue();
		String actualResult = manageLocation.getSearchedText();
		String expectedResult = manageLocation.getExpectedValueOfCountry();
		Assert.assertEquals(actualResult, expectedResult, "Missmatch");

	}

	@Test
	public void verifyUserAbleToChangeLocationStatus() throws InterruptedException {
		login = new LoginPage(driver);
		manageLocation = new ManageLocationPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageLocation.clickManageLocationTab();
		manageLocation.clickStatusIcon();
		Thread.sleep(3000);
		String actualResult = manageLocation.getAttributeValueOfAlert();
		String expecctedResult = manageLocation.getExpectedValue();
		Assert.assertEquals(actualResult, expecctedResult);
	}

	@Test
	public void verifyUserAbleToAddLocation() throws InterruptedException {
		login = new LoginPage(driver);
		manageLocation = new ManageLocationPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageLocation.clickManageLocationTab();
		manageLocation.clickNewButton();
		manageLocation.selectCountry(manageLocation.getCountryName());
		manageLocation.selectState(manageLocation.getValueOfStateToAdd());
		manageLocation.enterLocation(manageLocation.getValueOfStreet());
		manageLocation.enterDeliveryCharges(manageLocation.getDeliveryCharges());
		manageLocation.clickSaveButton();
		manageLocation.clickHomeButton();
		manageLocation.clickManageLocationTab();
		manageLocation.clickFirstSearchButton();
        manageLocation.selectCountry(manageLocation.getCountryName());
        manageLocation.selectState(manageLocation.getValueOfStateToAdd());
		manageLocation.clickSearchButtonAfterEnteringValue();
		manageLocation.smallDelay();
		String expectedResult = manageLocation.getExpectedLocation();
		String actualResult = manageLocation.getValueOfSearchedElement();
		Assert.assertEquals(actualResult, expectedResult);
	}
}