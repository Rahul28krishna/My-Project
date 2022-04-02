package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageCategoryPage extends InitializeUtility {
	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.MANAGE_CATEGORY_SHEET_NAME);

	@FindBy(xpath = "//i[@class='nav-icon fas fa-list-alt']")
	private WebElement manageCategoryTab;

	@FindBy(xpath = "//p[text()='Category']")
	private WebElement categoryTab;

	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategoryTab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonCategoryPage;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButtonSubCategoryPage;

	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	private WebElement editButtonSubcategoryTab;

	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement dropDownEditSubCategoryList;

	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryField;

	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButtonSubCategoryPage;

	@FindBy(xpath = "//div[@class='alert alert-alert alert-dismissible']")
	private WebElement errorMessageForDuplicateSubCategory;

	@FindBy(xpath = "//span[text()='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[2]")
	private WebElement targetElement;

	public void clickManageCategoryTab() {
		utilities.clickOnElement(manageCategoryTab);
	}

	public void clickcategoryTab() {
		utilities.clickOnElement(categoryTab);
	}

	public void clickNewButtonCategoryPage() {
		utilities.clickOnElement(newButtonCategoryPage);
	}

	public String getTitleAddCategoryPage() {
		String name = utilities.getPageTitle(driver);
		return name;
	}

	public void clickSubCategoryTab() {
		utilities.clickOnElement(subCategoryTab);
	}

	public void clickNewButtonSubCategoryPage() {
		utilities.clickOnElement(newButtonSubCategoryPage);
	}

	public String getTitleAddSubCategoryPage() {
		String name = utilities.getPageTitle(driver);
		return name;
	}

	public void clickEditSubCategoryButton() {
		utilities.clickOnElement(editButtonSubcategoryTab);

	}

	public void selectSubCategoryFromDropDown(String value) {
		utilities.selectFromDropDown(dropDownEditSubCategoryList, value);
	}

	public void clearSubCategoryTextField() {
		utilities.clearTheText(subCategoryField);
	}

	public void enterNewValueToSubCategoryField(String value) {
		utilities.enterValue(value, subCategoryField);
	}

	public void clickUpdateButton() {
		utilities.clickOnElement(updateButton);
	}

	public String getAttributeOfAlertMessage(String value) {
		return utilities.getAttributeValue(alertMessage, value);
	}

	public void clickSaveButtonSubCategoryPage() {
		utilities.clickOnElement(saveButtonSubCategoryPage);
	}

	public String getAttributeValueErrorMessage(String value) {
		return utilities.getAttributeValue(errorMessageForDuplicateSubCategory, value);
	}

	public String getTextOfNextButton() {
		return utilities.getElementText(nextButton);
	}

	public String getTextOfSubCategoryField() {
		return utilities.getElementText(subCategoryField);
	}

	public void scrollToNextButton() {
		utilities.scrollToElement(newButtonSubCategoryPage, driver);
	}

	public void clickClear() {
		utilities.clearTheText(subCategoryField);
	}

	public String getTextOfEditedElement() {
		return utilities.getElementText(targetElement);
	}

	public String getExpectedTitleOfAddCategoryPage() {
		return excelList.get(0);
	}

	public String getDataToEnter() {
		return excelList.get(1);
	}

	public String getValueToBeEntered() {
		return excelList.get(2);
	}

	public String getExpectedEditedValue() {
		return excelList.get(1);
	}

	public String getExpectedTitleOfSubCategoryPage() {
		return excelList.get(3);
	}

	public String getExpectedTextOfButton() {
		return excelList.get(4);
	}
}
