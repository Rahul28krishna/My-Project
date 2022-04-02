package executeClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpenseCategoryPage;
import elementRepository.LoginPage;

public class ExecuteExpenseCategory extends BaseClass {
	LoginPage login = new LoginPage(driver);
	ExpenseCategoryPage expenseCategory = new ExpenseCategoryPage(driver);

	@Test
	public void verifyTextOfNewButton() throws InterruptedException {
		expenseCategory = new ExpenseCategoryPage(driver);
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		expenseCategory.clickManageExpenseTab();
		expenseCategory.clickExpenseCategoryTab();
		Thread.sleep(3000);
		String actualResult = expenseCategory.getTextOfAddCateogryButton();
		String expectedResult =expenseCategory.getExpectedResult();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verifyThatUserIsAbleToSearchExpenseCategory() {
		expenseCategory = new ExpenseCategoryPage(driver);
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		expenseCategory.clickManageExpenseTab();
		expenseCategory.clickExpenseCategoryTab();
		expenseCategory.clickFirstSearch();
		expenseCategory.enterValueToBeSearched(expenseCategory.getElementToBeSearched());
		expenseCategory.clickSecondSearch();
		String actualResult = expenseCategory.getSearchedValue();
		String expectedResult = expenseCategory.getExpectedResultOfSearch();
		Assert.assertEquals(actualResult, expectedResult, "missmatch");

	}

	@Test
	public void verifyUserAbleToAddExpenseCategory() throws InterruptedException {
		expenseCategory = new ExpenseCategoryPage(driver);
		login = new LoginPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		expenseCategory.clickManageExpenseTab();
		expenseCategory.clickExpenseCategoryTab();
		expenseCategory.clickNewButton();
		expenseCategory.enterTitle(expenseCategory.getTitleOfExpenseCategory());
		expenseCategory.clickSaveButton();
		String actualResult = expenseCategory.getCreatedElement();
		String expectedResult = expenseCategory.getExpectedResultofNewAddCategory();
		Assert.assertEquals(actualResult, expectedResult, "Can not find");

	}

	@Test
	public void verifyErrorMessageForNoMatch() {
		login = new LoginPage(driver);
		expenseCategory = new ExpenseCategoryPage(driver);
		List<String> loginList = login.getLoginData();
		login.enterUsername(loginList.get(0));
		login.enterPassword(loginList.get(1));
		login.clickSignin();
		expenseCategory.clickManageExpenseTab();
		expenseCategory.clickExpenseCategoryTab();
		expenseCategory.clickFirstSearch();
		expenseCategory.enterValueToBeSearched(expenseCategory.getValueToBeSearched());
		expenseCategory.clickSecondSearch();
		String actualResult = expenseCategory.getErrorMessage();
		String expectedResult = expenseCategory.getExpectedErrorMessageForSearch();
		Assert.assertEquals(actualResult, expectedResult, "element there");

	}

	@Test
	public void verifyNoTwoExpensesWithSameNameCanBeCreated() {
		login = new LoginPage(driver);
		expenseCategory = new ExpenseCategoryPage(driver);
		login.enterUsername("admin");
		login.enterPassword("admin");
		login.clickSignin();
		expenseCategory.clickManageExpenseTab();
		expenseCategory.clickExpenseCategoryTab();
		expenseCategory.clickNewButton();
		expenseCategory.enterTitle(expenseCategory.getTitleWithSameNameOfExpense());
		expenseCategory.clickSaveButton();
		String actualResult = expenseCategory.getAttributeValueOfAlert();
		String expectedResult =expenseCategory.getExpectedValueOfAttribute();
		Assert.assertEquals(actualResult, expectedResult);
	}

}
