package elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtilities;
import Utilities.ExplicitWait;
import Utilities.GeneralUtilities;
import Utilities.InitializeUtility;

public class LoginPage extends InitializeUtility {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> excelList = excel.readDataFromExcel(Constant.LOGIN_PAGE_SHEET_NAME);

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinButton;

	@FindBy(xpath = "//li[@class='nav-item dropdown']//a[@data-toggle='dropdown']")
	private WebElement userLogged;

	@FindBy(xpath = "//label[@for='remember']")
	private WebElement loginPageRemeberCheckBox;

	public String getLoggedUser() {
		return utilities.getElementText(userLogged);
	}

	public void enterUsername(String usernameInput) {
		utilities.enterValue(usernameInput, userName);
	}

	public void enterPassword(String passwordInput) {
		utilities.enterValue(passwordInput, password);
	}

	public void clickSignin() {
		utilities.clickOnElement(signinButton);
	}

	public String getLoginText() {
		return utilities.getElementText(signinButton);
	}

	public void mouseHoverRememberCheckBox() {
		Actions action = new Actions(driver);
		action.moveToElement(loginPageRemeberCheckBox).perform();
	}

	public void clickRememberMeCheckBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='icheck-dark']//input")));
		utilities.clickOnElement(loginPageRemeberCheckBox);
	}

	public boolean clickRememberCheckBoxAndVerifyIsSelected() {
		utilities.clickOnElement(loginPageRemeberCheckBox);
		return utilities.isCheckBoxSelected(loginPageRemeberCheckBox);
	}

	public List<String> getLoginData() {
		return excelList;
	}

	public String getTitleDashboardPage() {
		return utilities.getPageTitle(driver);
	}

	public String getTitleLoginPage() {
		return utilities.getPageTitle(driver);
	}

	public String getExpectedValueOfPageTitle() {
		return excelList.get(3);
	}

	public String getExpectedTileOfLoginPage() {
		return excelList.get(4);
	}

	public String getExpectedNameOfLoggedUser() {
		return excelList.get(5);
	}

	public String getExpectedTextOfLoginButton() {
		return excelList.get(6);
	}
}
