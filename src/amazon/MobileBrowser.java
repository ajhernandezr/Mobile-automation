package amazon;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.lang.model.util.Elements;
import javax.swing.event.SwingPropertyChangeSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser {

	public static void main(String[] args) throws Exception {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "0123456789ABCDEF"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1");
		// caps.setCapability("browserName", "Browser");
		caps.setCapability("noReset", true);
		// caps.setCapability("noReset", "true");
		// caps.setCapability("unicodeKeyboard", true);
		// caps.setCapability("resetKeyboard", "true");
		caps.setCapability("autoGrantPermissions", true);
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Librerias automatizacion\\chromedriver.exe");
		// caps.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		// Instantiate Appium Driver
		AppiumDriver driver = null;
		try {
			driver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		// Open URL in Chrome Browser
		driver.get("http://www.google.com");

		MobileElement a = (MobileElement) driver.findElement(By.name("q"));
		a.sendKeys("Marca");

		MobileElement searchButton = (MobileElement) driver.findElement(By.className("gBCQ5d"));
		searchButton.click();

		MobileElement b = (MobileElement) driver
				.findElement(By.xpath(".//div[@id='main']//a[@href='http://www.marca.com/']"));

		int y = b.getLocation().getY();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + y + ")");

		b.click();

	}
}
