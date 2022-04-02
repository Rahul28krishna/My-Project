package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.InitializeUtility;

public class ManageCODPage extends InitializeUtility {
	WebDriver driver;

	public ManageCODPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.MANAGE_COD_SHEET_NAME);

	@FindBy(xpath = "//p[text()='Manage COD']")
	private WebElement manageCODTab;

	@FindBy(name = "cod")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;

	public void clickManageCODTab() {
		utilities.clickOnElement(manageCODTab);
	}

	public void clickYesRadioButton() {
		utilities.clickOnElement(yesRadioButton);
	}

	public Boolean checkYesRadioButtonSelected() {
		return utilities.isCheckBoxSelected(yesRadioButton);
	}

	public void clickSaveButton() {
		utilities.clickOnElement(saveButton);
	}

	public String getAttributeValueOfSuccessMessage() {
		return utilities.getAttributeValue(successMessage, "class");
	}

	public String getExpectedValue() {
		return excelList.get(0);
	}

}
