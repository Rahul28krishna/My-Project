package executeClasses;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import Utilities.ScreenShot;

public class BaseClass {
	WebDriver driver;
	ScreenShot screenshot;
	public static Properties properties;

	public static void testBasic() throws IOException {
		properties = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Config.properties");
		properties.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")

	public void beforeMethod(String browserName) throws IOException {
		testBasic();
		if (browserName.equals("chrome")) {
			String path = System.getProperty("user.dir") + "//src//main//resources//drivers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			String path = System.getProperty("user.dir") + "//src//main//resources//drivers//msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", path);
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			String path = System.getProperty("user.dir") + "//src//main//resources//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			screenshot = new ScreenShot();
			screenshot.captureFailureScreenshot(driver, iTestResult.getName());
		}
		driver.close();
	}

}
