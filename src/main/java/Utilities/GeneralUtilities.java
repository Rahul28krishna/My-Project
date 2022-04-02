package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	WebDriver driver;

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public boolean isCheckBoxSelected(WebElement element) {
		boolean check = element.isSelected();
		return check;
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void mouseHoverElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public boolean isButtonEnabled(WebElement element) {
		boolean check = element.isEnabled();
		return check;
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean check = element.isDisplayed();
		return check;
	}

	public void selectFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public void enterValue(String valueToEnter, WebElement element) {
		element.sendKeys(valueToEnter);
	}

	public void clearTheText(WebElement element) {
		element.clear();
	}

	public String getAttributeValue(WebElement element, String attribute) {
		String name = element.getAttribute(attribute);
		return name;
	}

	public String getPageTitle(WebDriver driver) {
		String name = driver.getTitle();
		return name;
	}

	public void scrollToElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)",element);
	}
	 public void smallDelay() throws InterruptedException {
		 Thread.sleep(3000);
	 }
	 public void acceptAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
	 }

}
