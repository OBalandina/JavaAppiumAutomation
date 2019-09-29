package lesson3.Test1Ex3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestEx3 {
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

    waitForElementByXpathAndClick(
            "//*[contains(@text,'Search Wikipedia')]",
            "Cannot find 'Search Wikipedia' input",
            5);

    waitForElementByXpathAndSendKeys("//*[contains(@text,'Search…')]",
            "Java",
            "Cannot find search input",
            5);

    waitForElementPresentByXpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']",
            "Cannot find 'Object-oriented programming language' topic searchink by 'Java'",
            15);

  }


  private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeOutInSeconds)
  {
    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
    wait.withMessage(error_message + "\n");
    By by = By.xpath(xpath);
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement waitForElementPresentByXpath(String xpath, String error_message)
  {
    return waitForElementPresentByXpath(xpath,error_message,5);
  }
 private  WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeOutInSeconds)
 {
   WebElement element = waitForElementPresentByXpath(xpath,error_message,5);
   element.click();
   return element;
 }
  private  WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeOutInSeconds)
  {
    WebElement element = waitForElementPresentByXpath(xpath,error_message,5);
    element.sendKeys(value);
    return element;
  }
}
