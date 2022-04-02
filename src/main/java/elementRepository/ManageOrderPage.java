package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageOrderPage extends InitializeUtility {
	WebDriver driver;

	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.MANAGE_ORDER_SHEET_NAME);

	@FindBy(xpath = "//p[text()='Manage Orders']")
	private WebElement manageOrderTab;

	@FindBy(xpath = "(//div[@class='col-sm-12']//a)[1]")
	private WebElement searchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[7]//a[1]")
	private WebElement viewButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[6]//a[2]")
	private WebElement changeDeliveryAddres;

	@FindBy(xpath = "(//input[@class='time1 time ui-timepicker-input'])[1]")
	private WebElement changeDeliveryTime;

	@FindBy(xpath = "(//button[@class='btn btn-info'])[2]")
	private WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSuccessfullyUpdate;

	@FindBy(xpath = "//input[@id='od']")
	private WebElement searchTextFieldID;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement errorMessage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchFinalButton;

	@FindBy(xpath = "(//h4[@class='card-title'])[2]")
	private WebElement headingResetPage;

	@FindBy(xpath = "(//a[text()='Assign Delivery Boy'])[1]")
	private WebElement deliveryBoyIcon;

	@FindBy(xpath = "(//select[@id='delivery_boy_id'])[1]")
	private WebElement deliveryBoySelectionDropDown;

	// @FindBy(xpath =
	// "(//select[@id='delivery_boy_id'])[1]//parent::div//following-sibling::div//button")
	@FindBy(xpath = "(//button[@name='assign_del'])[1]")
	private WebElement updateButtonDeliveryBoy;

	public void clickManageOrderTab() {
		utilities.clickOnElement(manageOrderTab);
	}

	public boolean searchButtonIsDisplayed() {
		return utilities.isElementDisplayed(searchButton);
	}

	public void clickViewButton() {
		utilities.clickOnElement(viewButton);
	}

	public String titleOfNextPage() {
		return utilities.getPageTitle(driver);
	}

	public void clickChangeDeliveryAddressIcon() {
		utilities.clickOnElement(changeDeliveryAddres);
	}

	public void enterNewDeliveryTime(String newTime) {
		utilities.clearTheText(changeDeliveryTime);
		utilities.enterValue(newTime, changeDeliveryTime);
	}

	public void clickUpdateButton() {
		utilities.clickOnElement(updateButton);
	}

	public String getAttributeOfAlert() {
		return utilities.getAttributeValue(alertSuccessfullyUpdate, "class");
	}

	public void clickSearchButton() {
		utilities.clickOnElement(searchButton);
	}

	public void enterTextToBeSearched(String name) {
		utilities.enterValue(name, searchTextFieldID);

	}

	public void clickSearchFinalButton() {
		utilities.clickOnElement(searchFinalButton);
	}

	public String getTextErrorMessage() {
		return utilities.getElementText(errorMessage);
	}

	public void clickResetButton() {
		utilities.clickOnElement(resetButton);
	}

	public String getHeadingResetPage() {
		return utilities.getElementText(headingResetPage);
	}

	public void clickDeleveryBoyIcon() {
		utilities.clickOnElement(deliveryBoyIcon);
	}

	public void selectDeliveryBoy() {
		utilities.selectFromDropDown(deliveryBoySelectionDropDown, "123");
	}

	public void clickUpdateButtonDeliveryBoy() {
		utilities.clickOnElement(updateButtonDeliveryBoy);
	}

	public void mouseHoverUpdateButton() {
		utilities.mouseHoverElement(updateButtonDeliveryBoy, driver);
	}

	public String getExpectedValue() {
		return excelList.get(2);
	}

	public String getTime() {
		return excelList.get(3);
	}

	public String getElementToBeSearched() {
		return excelList.get(1);
	}

	public String getExpectedErrorMessage() {
		return excelList.get(4);
	}

	public String getExpectedResult() {
		return excelList.get(5);
	}

	public String getExpectedStatusResult() {
		return excelList.get(6);
	}

}
