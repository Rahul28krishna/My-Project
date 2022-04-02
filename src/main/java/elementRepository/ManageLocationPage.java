package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageLocationPage extends InitializeUtility {
	WebDriver driver;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.MANAGE_LOCATION_SHEET_NAME);

	@FindBy(xpath = "//p[text()='Manage Location']")
	private WebElement manageLocationTab;

	@FindBy(id = "country_id")
	private WebElement countryDropDown;

	@FindBy(id = "st_id")
	private WebElement stateDroDown;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(name = "Search")
	private WebElement searchButtonAfterEnteringValue;

	@FindBy(xpath = "(//span[@class='badge bg-success'])[1]")
	private WebElement locationStatus;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement errorMeesageForNoMatch;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButtonFirst;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]")
	private WebElement searchedText;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='delivery']")
	private WebElement deliveryChargeTextField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[3]")
	private WebElement targetElement;

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deletedSuccessMessage;

	// @FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	// @FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deleteButton;

	public void clickFirstSearchButton() {
		utilities.clickOnElement(searchButtonFirst);
	}

	public void clickManageLocationTab() {
		utilities.clickOnElement(manageLocationTab);
	}

	public void selectCountry(String inputCountryName) {
		utilities.selectFromDropDown(countryDropDown, inputCountryName);
	}

	public void selectState(String inputStateName) {
		utilities.selectFromDropDown(stateDroDown, inputStateName);
	}

	public void enterLocation(String inputLocation) {
		utilities.enterValue(inputLocation, location);
	}

	public void clickSearchButtonAfterEnteringValue() {
		utilities.clickOnElement(searchButtonAfterEnteringValue);
	}

	public String getTextOfErrorMessageIfNoMatch() {
		return utilities.getElementText(errorMeesageForNoMatch);

	}

	public String getSearchedText() {
		return utilities.getElementText(searchedText);
	}

	public void clickStatusIcon() {
		utilities.clickOnElement(locationStatus);
	}

	public String getAttributeValueOfDeleteSuccess() {
		return utilities.getAttributeValue(deletedSuccessMessage, "class");
	}

	public String getAttributeValueOfAlert() {
		return utilities.getAttributeValue(alertMessage, "class");
	}

	public void clickNewButton() {
		utilities.clickOnElement(newButton);
	}

	public void enterDeliveryCharges(String value) {
		utilities.enterValue(value, deliveryChargeTextField);
	}

	public void clickSaveButton() {
		utilities.clickOnElement(saveButton);
	}

	public String getValueOfSearchedElement() {
		return utilities.getElementText(targetElement);
	}

	public void clickHomeButton() {
		utilities.clickOnElement(homeButton);
	}

	public void clickDeleteButton() {
		utilities.clickOnElement(deleteButton);
	}

	public void scrollToDeleteButton() {
		utilities.scrollToElement(deleteButton, driver);

	}

	public void mouseHoverToDeleteButton() {
		utilities.mouseHoverElement(deleteButton, driver);
	}

	public String getCountryName() {
		// TODO Auto-generated method stub
		return excelList.get(0);
	}

	public String getStateName() {
		// TODO Auto-generated method stub
		return excelList.get(1);
	}

	public String getStreetName() {
		// TODO Auto-generated method stub
		return excelList.get(2);
	}

	public String getErrorMessageForNoSearch() {
		// TODO Auto-generated method stub
		return excelList.get(3);
	}

	public String getStateNameForSearch() {
		// TODO Auto-generated method stub
		return excelList.get(4);
	}

	public String getExpectedValueOfCountry() {
		// TODO Auto-generated method stub
		return excelList.get(4);
	}

	public String getExpectedValue() {
		// TODO Auto-generated method stub
		return excelList.get(5);
	}

	public String getValueOfStateToAdd() {
		// TODO Auto-generated method stub
		return excelList.get(6);
	}

	public String getValueOfStreet() {
		// TODO Auto-generated method stub
		return excelList.get(7);
	}

	public String getDeliveryCharges() {
		// TODO Auto-generated method stub
		return excelList.get(8);
	}

	public String getExpectedLocation() {
		// TODO Auto-generated method stub
		return excelList.get(6);
	}

	public String getValueOfStateToDelete() {
		// TODO Auto-generated method stub
		return excelList.get(6);
	}

	public void prescenceOfElementWait() {
		wait.presenceOfElement(driver, "(//i[@class='fas fa-trash-alt'])[1]");
	}

	public void elementToBeClickable() {
		wait.elementToBeClickable(driver, "(//i[@class='fas fa-trash-alt'])[1]");
	}
	public void smallDelay() throws InterruptedException {
		utilities.smallDelay();
	}

}
