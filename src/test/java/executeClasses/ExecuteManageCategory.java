package executeClasses;

import java.time.Duration;
import java.util.List;

import javax.swing.text.Utilities;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;



public class ExecuteManageCategory extends BaseClass {
	LoginPage login;
	ManageCategoryPage manageOrder;

	@Test
	public void verifyUserAbleToNavigateToAddCategoryPage() {
		login = new LoginPage(driver);
		manageOrder = new ManageCategoryPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageCategoryTab();
		manageOrder.clickcategoryTab();
		manageOrder.clickNewButtonCategoryPage();
		String actualResult = manageOrder.getTitleAddCategoryPage();
		String expectedResult = manageOrder.getExpectedTitleOfAddCategoryPage();
		Assert.assertEquals(actualResult, expectedResult);
	}


	@Test
	public void verifyUserCanEditSubCategoryInformation() {
		LoginPage login = new LoginPage(driver);
		manageOrder = new ManageCategoryPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageCategoryTab();
		manageOrder.clickSubCategoryTab();
		manageOrder.clickEditSubCategoryButton();
		manageOrder.selectSubCategoryFromDropDown(manageOrder.getDataToEnter());
		manageOrder.clearSubCategoryTextField();
		manageOrder.enterNewValueToSubCategoryField(manageOrder.getValueToBeEntered());
		manageOrder.clickUpdateButton();
		String actualResult = manageOrder.getTextOfEditedElement();
		String expectedResult = manageOrder.getExpectedEditedValue();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyUserAbleToNavigateToAddSubCategoryPage() {
		LoginPage login = new LoginPage(driver);
		manageOrder = new ManageCategoryPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageCategoryTab();
		manageOrder.clickSubCategoryTab();
		manageOrder.clickNewButtonSubCategoryPage();
		String actualResult = manageOrder.getTitleAddSubCategoryPage();
		String expectedResult = manageOrder.getExpectedTitleOfSubCategoryPage();
		Assert.assertEquals(actualResult, expectedResult);
	}


	@Test
	public void verifyTextOfNextButton() {
		LoginPage login = new LoginPage(driver);
		manageOrder = new ManageCategoryPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		manageOrder.clickManageCategoryTab();
		manageOrder.clickSubCategoryTab();
		manageOrder.scrollToNextButton();
		String actualResult = manageOrder.getTextOfNextButton();
		String expectedResult =manageOrder.getExpectedTextOfButton();
		Assert.assertEquals(actualResult, expectedResult);

	}
}
