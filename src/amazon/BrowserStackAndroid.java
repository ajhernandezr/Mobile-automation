package amazon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackAndroid {
	  
	  public static String userName = "albertohernandez3";
	  public static String accessKey = "DDEyYF7RzYKKfVTE4ACx";

	  public static void main(String args[]) throws MalformedURLException, InterruptedException {
	    DesiredCapabilities caps = new DesiredCapabilities();

	    caps.setCapability("device", "Samsung Galaxy S8 Plus");
	    caps.setCapability("app", "bs://e094f5e628dc713be2bb23074c22d1b734eba1dd");
	    caps.setCapability("browserstack.debug", "true");

	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
	    searchElement.click();
	    AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	        ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
	    insertTextElement.sendKeys("BrowserStack");
	    Thread.sleep(5000);

	    List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
	    assert(allProductsName.size() > 0);

	    driver.quit();
	  }
	}