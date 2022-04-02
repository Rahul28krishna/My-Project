package executeClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageGroups;

public class ExecuteManageGroups extends BaseClass {
	LoginPage login;
	ManageGroups manageGroups = new ManageGroups(driver);

	@Test(groups = "critical")
	public void verifyUserAbleToCreateGroup() {
		login = new LoginPage(driver);
		manageGroups = new ManageGroups(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickNewButton();
		manageGroups.enterNewGroup(manageGroups.getValueOfNewgroup());
		manageGroups.clickSaveButton();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickSearchButton();
		manageGroups.enterValueToBeSearched(manageGroups.getValueToBeSearched());
		manageGroups.clickSearchButtonAfterEnteringValue();
		String actualResult = manageGroups.getValueOfSearchedElement();
		String expectedResult = manageGroups.getExpectedValueOfGroup();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyUserAbleToSearchASpecificGroup() {
		login = new LoginPage(driver);
		manageGroups = new ManageGroups(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageGroups.elementToBeClickable();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickSearchButton();
		manageGroups.enterValueToBeSearched(manageGroups.getValueOfGroup());
		manageGroups.clickSearchButtonAfterEnteringValue();
		String expectedResult = manageGroups.getExpectedValueOfSearch();
		String actualResult = manageGroups.getValueOfSearchedElement();
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(groups = "critical")
	public void verifyErrorMessageForInvalidSearch() {
		login = new LoginPage(driver);
		manageGroups = new ManageGroups(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickSearchButton();
		manageGroups.enterValueToBeSearched(manageGroups.getValueForSearch());
		manageGroups.clickSearchButtonAfterEnteringValue();
		String expectedResult = manageGroups.getTextErrorMeesage();
		String actualResult = manageGroups.getTextOFerrorMessage();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyNoTwoGroupsWithSameNameCanBeCreated() {
		login = new LoginPage(driver);
		manageGroups = new ManageGroups(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickNewButton();
		manageGroups.enterNewGroup(manageGroups.getValueOfNewGroup());
		manageGroups.clickSaveButton();
		String actualResult = manageGroups.getAttributeValueOfErrorMessage();
		String expectedResultResult = manageGroups.getExpectedResult();
		Assert.assertEquals(actualResult, expectedResultResult);

	}

	@Test
	public void verifyUserCanDeleteASpecificGroup() {
		login = new LoginPage(driver);
		manageGroups = new ManageGroups(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageGroups.clickManageGroupsTab();
		manageGroups.clickNewButton();
		manageGroups.enterNewGroup(manageGroups.getValueOfGroupToCreate());
		manageGroups.clickSaveButton();
		manageGroups.clickHomeButton();
		manageGroups.clickManageGroupsTab();
        manageGroups.clickDeleteButton();
        manageGroups.acceptAlertOfDeletion();
        manageGroups.clickSearchButton();
		manageGroups.enterValueToBeSearched(manageGroups.getValueToSearch());
		manageGroups.clickSearchButtonAfterEnteringValue();
		String actualResult = manageGroups.getTextOFerrorMessage();
		String expectedResult =manageGroups.getErrorMessageForNoSearch();
		Assert.assertEquals(actualResult, expectedResult);

	}

}
