package amazon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartApplication {
	
	public static void main(String[] args) {
		AndroidDriver<MobileElement> driver = null;

		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "0123456789ABCDEF"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1");
		caps.setCapability("appPackage", "com.greenlionsoft.free.madrid");
		caps.setCapability("appActivity", "com.greenlionsoft.free.madrid.app.ui.activities.MainActivity");
	//	caps.setCapability("noReset", "true");
	//	caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", "true");
		caps.setCapability("autoGrantPermissions",true);
		//Instantiate Appium Driver
		try {
			 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		// Code
			
		driver.findElement(By.xpath(".//*[@text='Empezar']")).click();
		
		driver.findElement(By.xpath(".//*[@text='Aceptar y continuar']")).click();
		
		 driver.findElement(By.className("android.widget.CheckBox")).click();

		driver.findElement(By.xpath(".//*[@text='Aceptar y continuar']")).click();
		
		driver.findElement(By.xpath(".//*[@text='METRO']")).click();
		
		 driver.findElement(By.className("android.widget.EditText")).click();
		 
		 AndroidElement element = (AndroidElement) driver.findElementById(("com.greenlionsoft.free.madrid:id/metroLinesActv"));

		 element.clear();
		 element.click();
		 
		
	 element.sendKeys("Prin");
		 
		 //	 driver.findElement(By.className("android.widget.EditText")).sendKeys("Principe pio");
			
		 driver.findElement(By.id("com.greenlionsoft.free.madrid:id/searchFab")).click();


	}

}
 
