package lesson2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {

  private AppiumDriver driver;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities Capabilities = new DesiredCapabilities();
    Capabilities.setCapability("platformName", "Android");
    Capabilities.setCapability("deviceName", "emulator-5554 (9)");
    Capabilities.setCapability("platformVersion", "9");
    Capabilities.setCapability("automationName", "Appium");
    Capabilities.setCapability("appPackage", "org.wikipedia");
    Capabilities.setCapability("appActivity", ".main.MainActivity");
    Capabilities.setCapability("app", "D:\\GitHub\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void firstTest() {
    WebElement element_to_init_search = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
    element_to_init_search.click();

    WebElement element_to_enter_search_line = driver.findElementByXPath("//*[contains(@text,'Search…')]");
//    element_to_enter_search_line.sendKeys("Appium");
   if (!element_to_enter_search_line.equals("//*[contains(@text,'Search…')]")) {
     element_to_enter_search_line.sendKeys("Appium");
   } else {
     Assert.assertTrue("Ошибка, нет текста Search!", element_to_enter_search_line.equals("//*[contains(@text,'Search…')]"));
//      System.out.println("Ошибка");
    }




  }

}
