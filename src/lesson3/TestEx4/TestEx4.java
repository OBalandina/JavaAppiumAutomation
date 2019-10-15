package lesson3.TestEx4;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestEx4 {
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



//  @Test
//  public void testSearch() {
//
//    waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//    waitForElementPresent(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Object-oriented programming language' topic searchink by 'Java'",
//            15);
//
//  }
//
//  @Test
//  public void testCancelSearch() {
//    waitForElementAndClick(
//            By.id("org.wikipedia:id/search_container"),
//            "Cannot find 'Search Wikipedia' input",
//            5
//    );
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//    waitForElementAndClear(
//            By.id("org.wikipedia:id/search_src_text"),
//            "Cannot find search field",
//            5);
//
//
//    waitForElementAndClick(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "Cannot find X to cancel 'Search'",
//            5
//
//    );
//
//    waitForElementNotPresent(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "X is still present on the page",
//            5
//
//    );
//
//  }

      /* Ex4* */
  @Test
  public void testSearchWordsInSearch () {

    waitForElementAndClick(
            By.id("org.wikipedia:id/search_container"),
            "Cannot find 'Search Wikipedia' input",
            5
    );

    String word = "Java";

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            word,
            "Cannot find search input",
            5);

    waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'Java')]"),
            "Cannot find element 'word'",
            15);

  }


//    waitForElementPresent(
//            By.id ("org.wikipedia:id/page_list_item_title"),
//            "Cannot find 'Object-oriented programming language' topic searchink by 'Java'",
//            15);
//
//    WebElement title_element = waitForElementPresent(
//            By.id("org.wikipedia:id/page_list_item_title"),
//            "Cannot find in 'Search' value 'word'",
//            15) ;
//
//     String article_title = title_element.getAttribute("text");
////
//     Assert.assertEquals(
//            "Text in 'Search' != value 'word' ",
//            "It's ok - 'word'",
//             article_title);




//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//
//    waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    WebElement title_element = waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//            "Cannot Article Title",
//            15);
//
//    String article_title =title_element.getAttribute("text");
//
//    Assert.assertEquals(
//            "We see unexpected title",
//            "Java (programming language)",
//            article_title);





//  @Test
//  public void testCompareArticleTitle(){
//    waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//
//    waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    WebElement title_element = waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//            "Cannot Article Title",
//            15);
//
//    String article_title =title_element.getAttribute("text");
//
//    Assert.assertEquals(
//            "We see unexpected title",
//            "Java (programming language)",
//            article_title);
//  }

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

  private boolean waitForElementNotPresent(By by,String error_message, long timeOutInSeconds)
  {
    WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
    wait.withMessage(error_message+"\n");
    return wait.until(
            ExpectedConditions.invisibilityOfElementLocated(by)
    );
  }

  private WebElement waitForElementAndClear(By by,String error_message, long timeOutInSeconds)
  {
    WebElement element = waitForElementPresent(by,error_message,timeOutInSeconds);
    element.clear();
    return element;
  }

}