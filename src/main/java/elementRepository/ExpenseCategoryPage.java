package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ExpenseCategoryPage extends InitializeUtility {
	WebDriver driver;

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.EXPENSE_CATEGORY_SHEET_NAME);

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseTab;

	@FindBy(xpath = "//p[text()='Expense Category']")
	private WebElement expenseCategoryTab;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement addNewCategoryButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButtonFirst;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonSecond;

	@FindBy(id = "un")
	private WebElement searchBox;

	@FindBy(xpath = "//td[1]")
	private WebElement targetElement;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newExpenseCategoryButton;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement enterTitle;

	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	private WebElement addedExpense;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement errorMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;

	public void clickManageExpenseTab() {
		wait.presenceOfElement(driver, "//i[@class='nav-icon fas fa-money-bill-alt']");
		utilities.clickOnElement(manageExpenseTab);
	}

	public void clickExpenseCategoryTab() {
		wait.presenceOfElement(driver, "//p[text()='Expense Category']");
		utilities.clickOnElement(expenseCategoryTab);
	}

	public String getTextOfAddCateogryButton() {
		return utilities.getElementText(addNewCategoryButton);

	}

	public void clickFirstSearch() {
		utilities.clickOnElement(searchButtonFirst);
	}

	public void enterValueToBeSearched(String inputValue) {
		utilities.enterValue(inputValue, searchBox);
	}

	public void clickSecondSearch() {
		utilities.clickOnElement(searchButtonSecond);
	}

	public String getSearchedValue() {
		String name = utilities.getElementText(targetElement);
		return name;
	}

	public void clickNewButton() {
		utilities.clickOnElement(newExpenseCategoryButton);

	}

	public void enterTitle(String inputValue) {
		utilities.enterValue(inputValue, enterTitle);
	}

	public void clickSaveButton() {
		utilities.clickOnElement(saveButton);
	}

	public String getCreatedElement() {
		String name = utilities.getElementText(targetElement);
		return name;
	}

	public String getErrorMessage() {
		String name = utilities.getElementText(errorMessage);
		return name;
	}

	public String getAlertMessage() {
		String name = utilities.getElementText(alertMessage);
		return name;
	}

	public String getAttributeValueOfAlert() {
		return utilities.getAttributeValue(alertMessage, "class");
	}

	public String getExpectedResult() {
		return excelList.get(0);
	}

	public String getExpectedResultOfSearch() {
		return excelList.get(1);
	}

	public String getTitleOfExpenseCategory() {
		return excelList.get(2);
	}

	public String getExpectedResultofNewAddCategory() {
		return excelList.get(2);
	}

	public String getValueToBeSearched() {
		// TODO Auto-generated method stub
		return excelList.get(3);
	}

	public String getExpectedErrorMessageForSearch() {
		// TODO Auto-generated method stub
		return excelList.get(4);
	}

	public String getTitleWithSameNameOfExpense() {
		// TODO Auto-generated method stub
		return excelList.get(1);
	}

	public String getExpectedValueOfAttribute() {
		// TODO Auto-generated method stub
		return excelList.get(5);
	}

	public String getElementToBeSearched() {
		return excelList.get(1);
	}
}
