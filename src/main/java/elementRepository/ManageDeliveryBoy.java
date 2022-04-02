package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageDeliveryBoy extends InitializeUtility {
	WebDriver driver;

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.DELIVERY_BOY_SHEET_NAME);
	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	private WebElement manageDeliveryBoyTab;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement deliveryBoyNameField;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement deliveryBoyContactnumber;

	@FindBy(name = "create")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchNameField;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonAfterEnteringDetails;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	private WebElement searchedElement;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement errorMessageForNoSearch;

	@FindBy(xpath = "(//span[text()='Active'])[1]")
	private WebElement statusIcon;

	@FindBy(xpath = "(//span[text()='Inactive'])[1]")
	private WebElement inActiveStatusIcon;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement statusChangedMessage;

	public void clickManageDeliveryBoyTab() {
		utilities.clickOnElement(manageDeliveryBoyTab);
	}

	public void clickNewButton() {
		utilities.clickOnElement(newButton);
	}

	public void enterName(String name) {
		utilities.enterValue(name, deliveryBoyNameField);
	}

	public void enterContactNumber(String value) {
		utilities.enterValue(value, deliveryBoyContactnumber);
	}

	public void clickSaveButton() {
		utilities.clickOnElement(saveButton);
	}

	public void scrollTheElement() {
		utilities.scrollToElement(saveButton, driver);
	}

	public void mouseHoverSaveButton() {
		utilities.mouseHoverElement(saveButton, driver);
	}

	public void presenceOfElementWait() {
		wait.presenceOfElement(driver, "button[@class='btn btn-danger']");
	}

	public void elementToBeClickable() {
		wait.elementToBeClickable(driver, "//button[text()='Save']");
	}

	public void clickSearchButton() {
		utilities.clickOnElement(searchButton);
	}

	public void enterValueInNameFieldForSearch(String name) {
		utilities.enterValue(name, searchNameField);
	}

	public void clickSearchButtonAfterEnteringDetails() {
		utilities.clickOnElement(searchButtonAfterEnteringDetails);
	}

	public String getActualSearchedElement() {
		return utilities.getElementText(searchedElement);
	}

	public void getTextOfErrorMessage() {
		utilities.getElementText(errorMessageForNoSearch);
	}

	public void clickStatusIcon() {
		utilities.clickOnElement(statusIcon);
	}

	public String getAttributeValueOfSuccessMessage(String value) {
		return utilities.getAttributeValue(statusChangedMessage, value);
	}

	public void clickInactiveStatusIcon() {
		utilities.clickOnElement(inActiveStatusIcon);
	}

	public void waitForPresenceOfInactiveIcon() {
		wait.presenceOfElement(driver, "(//span[text()='Inactive'])[1]");
	}

	public String getExpectedSearchElement() {
		return excelList.get(1);
	}

	public String getElementToSearch() {
		return excelList.get(1);
	}

	public String getNameToEnter() {
		return excelList.get(2);
	}

	public String getContactToEnter() {
		return excelList.get(3);
	}

	public String getValueToSearch() {
		return excelList.get(4);
	}

	public String getExpectedErrorMessage() {

		return excelList.get(5);
	}

	public String getAttributeType() {
		return excelList.get(6);
	}

//	public void enterUserNameForCreatinNewDeliverBoy() {
//		login.enterUsername("admin");
//		
//	}
//	public void enterPasswordForCreatingNewDeliverBoy() {
//		login.enterPassword("admin");
//	}
	public String getExpectedAttributeValue() {
		return excelList.get(7);
	}

	public void smallDelay() throws InterruptedException {
		utilities.smallDelay();
	}

}
