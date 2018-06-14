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

public class BrowserStackAndroidMetro {

	public static String userName = "albertohernandez3";
	public static String accessKey = "DDEyYF7RzYKKfVTE4ACx";

	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("device", "Samsung Galaxy S8 Plus");
		caps.setCapability("app", "bs://60a1b16bed829e8a0cfc7b9c054050ff96d46810");
		caps.setCapability("browserstack.debug", "true");
		//caps.setCapability("appActivity", "com.greenlionsoft.free.madrid.app.ui.activities.MainActivity");
		//caps.setCapability("Reset", "true");
		
		
		// Code
	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	//	driver.findElement(By.xpath(".//*[@text='Empezar']")).click();

	//	driver.findElement(By.xpath(".//*[@text='Aceptar y continuar']")).click();

	//		driver.findElement(By.className("android.widget.CheckBox")).click();

	//		driver.findElement(By.xpath(".//*[@text='Aceptar y continuar']")).click();
	    
		driver.findElement(By.xpath(".//*[@text='LATER']")).click();

		driver.findElement(By.xpath(".//*[@text='METRO']")).click();
		
		driver.findElement(By.xpath(".//*[@text='TRIP CALCULATOR']")).click();

		driver.findElement(By.className("android.widget.EditText")).click();
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Principe Pio");

		

	

		// driver.findElement(By.className("android.widget.EditText")).sendKeys("Principe
		// pio");

	//	driver.findElement(By.id("com.greenlionsoft.free.madrid:id/searchFab")).click();

		driver.quit();
	}
}