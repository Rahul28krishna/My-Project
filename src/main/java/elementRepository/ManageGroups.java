package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageGroups extends InitializeUtility {
	WebDriver driver;

	public ManageGroups(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	List<String> excelList = excel.readDataFromExcel(Constant.MANAGE_GROUPS_SHEET_NAME);

	@FindBy(xpath = "//p[text()='Manage Groups']")
	private WebElement manageGroupsTab;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@name='titlep']")
	private WebElement groupNameInputField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchInputField;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonAfterEnteringValue;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	private WebElement searchedElement;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement noSearchResult;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorMessageDuplicateValue;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeButton;

	public void clickManageGroupsTab() {
		utilities.clickOnElement(manageGroupsTab);
	}

	public void clickNewButton() {
		utilities.clickOnElement(newButton);
	}

	public void enterNewGroup(String name) {
		utilities.enterValue(name, groupNameInputField);
	}

	public void clickSaveButton() {
		utilities.clickOnElement(saveButton);
	}

	public void clickSearchButton() {
		utilities.clickOnElement(searchButton);
	}

	public void enterValueToBeSearched(String value) {
		utilities.enterValue(value, searchInputField);
	}

	public void clickSearchButtonAfterEnteringValue() {
		utilities.clickOnElement(searchButtonAfterEnteringValue);
	}

	public String getValueOfSearchedElement() {
		return utilities.getElementText(searchedElement);

	}

	public String getTextOFerrorMessage() {
		return utilities.getElementText(noSearchResult);
	}

	public String getAttributeValueOfErrorMessage() {
		return utilities.getAttributeValue(errorMessageDuplicateValue, "class");
	}

	public void clickResetButton() {
		utilities.clearTheText(resetButton);

	}

	public Boolean isGroupInputFieldDisplayed() {
		return utilities.isElementDisplayed(groupNameInputField);
	}

	public void clickDeleteButton() {
		utilities.clickOnElement(deleteButton);
	}

	public void elementToBeClickable() {
		wait.elementToBeClickable(driver, "//p[text()='Manage Groups']");
	}

	public void scrollToElement() {
		utilities.scrollToElement(manageGroupsTab, driver);
	}

	public String getValueOfNewgroup() {
		return excelList.get(0);
	}

	public String getValueToBeSearched() {
		return excelList.get(1);
	}

	public String getExpectedValueOfGroup() {
		return excelList.get(1);
	}

	public String getValueOfGroup() {
		return excelList.get(2);
	}

	public String getExpectedValueOfSearch() {
		return excelList.get(2);
	}

	public String getValueForSearch() {
		return excelList.get(3);
	}

	public String getTextErrorMeesage() {
		return excelList.get(4);
	}

	public String getValueOfNewGroup() {
		return excelList.get(2);
	}

	public String getExpectedResult() {
		return excelList.get(5);
	}

	public String getValueOfGroupToCreate() {
		return excelList.get(6);
	}
	public String getValueToSearch() {
		return excelList.get(6);
	}
	public void clickHomeButton() {
		utilities.clickOnElement(homeButton);
	}
	public void acceptAlertOfDeletion() {
		utilities.acceptAlert(driver);
	}

	public String getErrorMessageForNoSearch() {
		return excelList.get(7);
	}
}