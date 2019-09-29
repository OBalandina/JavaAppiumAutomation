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

    waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "Cannot find search input",
            5);

    waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find 'Object-oriented programming language' topic searchink by 'Java'",
            15);

  }

  @Test
  public void testCancelSearch() {
    waitForElementAndClick(
            By.id("org.wikipedia:id/search_container"),
            "Cannot find 'Search Wikipedia' input",
            5
    );

    waitForElementAndClick(
            By.id("org.wikipedia:id/search_close_btn"),
            "Cannot find X to cancel 'Search'",
            5

    );

    waitForElementNotPresent(
            By.id("org.wikipedia:id/search_close_btn"),
            "X is still present on the page",
            5

    );

  }

  private WebElement waitForElementPresent(By by, String error_message, long timeOutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private WebElement waitForElementPresent(By by, String error_message) {
    return waitForElementPresent(by, error_message, 5);
  }

  private WebElement waitForElementAndClick(By by, String error_message, long timeOutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, 5);
    element.click();
    return element;
  }

  private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, 5);
    element.sendKeys(value);
    return element;
  }

//  private WebElement waitForElementPresentById(String id, String error_message, long timeOutInSeconds) {
//    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//    wait.withMessage(error_message + "\n");
//    By by = By.id(id);
//    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//  }
//
//  private WebElement waitForElementByIdAndClick(String id, String error_message, long timeOutInSeconds) {
//    WebElement element = waitForElementPresentById(id, error_message, 5);
//    element.click();
//    return element;
//
//  }
  private boolean waitForElementNotPresent(By by,String error_message, long timeOutInSeconds)
  {
    WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
    wait.withMessage(error_message+"\n");
    return wait.until(
            ExpectedConditions.invisibilityOfElementLocated(by)
    );

  }
}