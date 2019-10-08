package lesson4.Ex7;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class TestEx7 {
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

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

//  @Test
//  public void firstTest() {
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

  @Test
  public void testSwipeArticle(){
    waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            "Appium",
            "Cannot find search input",
            5);

    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']"),
            "Cannot find 'Appium' article in Search",
            5);

    waitForElementPresent(
            By.id("org.wikipedia:id/view_page_title_text"),
            "Cannot find 'Article Title'",
            15);


    swipeUpToFindElement(
    By.xpath("//*[@text='View page in browser']"),
            "Cannot find the end of the article",
            15);


  }


  @Test
  public  void saveFirstArticleToMyList()    // сохранение в лист
  {
    waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "Cannot find search input",
            5);

    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find 'Search Wikipedia' input",
            5);

    waitForElementPresent(
            By.id("org.wikipedia:id/view_page_title_text"),  // ищем название текста (хедер) по resource-id
            "Cannot Article Title",
            5);

    waitForElementAndClick(
            By.xpath("//android.widget.ImageView[@content-desc='More options']"),   // из аппиум берем class и content-desc
            "Cannot find button to open article options ", // кнопка опции - три точки в правом вверхнем углу
            5 );

    waitForElementAndClick(
            By.xpath("//*[@text='Add to reading list']"), // в кнопке опции клик по 'Add to reading list'
            "Cannot find option to 'Add to reading list'",
            5);

    waitForElementAndClick(
            By.id("org.wikipedia:id/onboarding_button"), // из аппиум берем resource-id кнопки
            "Cannot find button 'GOT IT'",
            5);

    waitForElementAndClear(
        By.id("org.wikipedia:id/text_input"),
        "Cannot find input to set name of articles folder", // очищаем текст
        5);


   String name_of_Folder = "Learning Programming";


    waitForElementAndSendKeys(
            By.id("org.wikipedia:id/text_input"),
            name_of_Folder ,   // "Learning Programming"
            "Cannot put text into articles folder input",  // ввод значения в строку, наименование папки "Learning Programming"
            5);

    waitForElementAndClick(
            By.xpath("//*[@text='OK']"),  //нажимаем кнопку "ок"
            " Cannot press 'OK' button",
            5);

    waitForElementAndClick(
            By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), // из аппиум берем class и content-desc нашла кнопку с помощью App Sourse  в аппиум
            "Cannot close article, cannot find X link", // не находим кнопку X (слева вврху)
            5);

    waitForElementAndClick(
            By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), // из аппиум берем class и content-desc
            "Cannot find navigation button to 'My lists'", // не находим кнопку Му лист
            5);

    waitForElementAndClick(
            By.xpath("//*[@text='"+ name_of_Folder +"']"), // из аппиум берем text   "//*[@text='Learning Programming']"
            "Cannot find created folder", // не находим список 'Learning Programming'
            5);

//    waitForElementPresent(
//            By.id("org.wikipedia:id/item_container"),  // ищем название текста (хедер) по resource-id
//            "Cannot find folder",
//            5);

    swipeElementToLeft(
              By.xpath("//*[@text='Java (programming language)']"), // из аппиум берем text
              "Cannot find saved article" );         // не находим в списке 'Learning Programming' -Java (programming language)


    waitForElementNotPresent(
            By.xpath("//*[@text='Java (programming language)']"), // из аппиум берем text
            "Cannot delete saved  article",
            5);



  }

  @Test
  public void testAmountOfNotEmptySearch()
  {
    waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    String search_line = "Linking Park discography";

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "Cannot find search input",
            5);

    String search_result_locator = "//*[@resource_id='org.wikipedia:id/search_results_list']/*[@resource_id='org.wikipedia:id/page_list_item_title']";   // resource_id для родителя и затем для доченего элемента

    waitForElementPresent(
            By.xpath(search_result_locator),
            "Cannot find anything by the request" + search_line,
            15);



    int amount_of_search_results = getAmoundOfElements(
            By.xpath(search_result_locator)
    );

    Assert.assertTrue(
            "We found too few results!",
            amount_of_search_results>0
    );
  }

  @Test
  public void testAmountOfEmptySearch ()
  {
    waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    String search_line = "dfdghfjfjfjfj";

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "Cannot find search input",
            5);

    String search_result_locator = "//*[@resource_id='org.wikipedia:id/search_results_list']/*[@resource_id='org.wikipedia:id/page_list_item_title']";   // resource_id для родителя и затем для доченего элемента
    String empty_result_label = "//*[@text='No results found']";

    waitForElementPresent(
            By.xpath(empty_result_label),
            "Cannot find empty result label by the request" + search_line,
            15);

    assertElementNotPresent(
            By.xpath(search_result_locator),
            "We've found some results by request" + search_line);

  }

  @Test
  public  void testChangeScreenOrientationOnSearchResults ()
  {
    waitForElementAndClick(
            By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    String search_line = "Java";

    waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            search_line,
            "Cannot find search input",
            5);

    waitForElementAndClick(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find 'Object-oriented programming language' topic searching by" + search_line,
            15);

    String title_before_rotation = waitForElementAndGetAttribute(
            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
           "text",
            "Cannot find  title of article",
            15);

     driver.rotate(ScreenOrientation.LANDSCAPE);

    String title_after_rotation = waitForElementAndGetAttribute(
            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
            "text",
            "Cannot find  title of article",
            15);


    Assert.assertEquals(
            "Article title have been changed after screen rotation",
            title_before_rotation,title_after_rotation);

    driver.rotate(ScreenOrientation.PORTRAIT);

    String title_after_second_rotation = waitForElementAndGetAttribute(
            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
            "text",
            "Cannot find  title of article",
            15);

    Assert.assertEquals(
            "Article title have been changed after screen rotation",
            title_before_rotation,title_after_second_rotation);
  }


  @Test
  public void testCheckSearchArticleInBackground ()
  {
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
            "Cannot find 'Search Wikipedia' input",
            5);

    driver.runAppInBackground(2);

    waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find article after returning from background",
            5);

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

  protected void swipeUp(int timeOfSwipe)
  {
    TouchAction action = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int start_y = (int)(size.height * 0.8);
    int end_y = (int)(size.height * 0.2);
    action.press(x, start_y)
            .waitAction(timeOfSwipe)
            .moveTo(x, end_y)
            .release().
            perform();

  }

  protected void swipeUpQuick()
  {
    swipeUp(200);

  }
protected  void swipeUpToFindElement(By by,String error_message,int max_swipes) //нужно элемента нет, прокручивает страницу вниз, до тех пор пка не достигнет футора
{
//  driver.findElements(by);
//  driver.findElements(by).size();

  int already_swiped = 0; // переменная в которую записывается реальное кол-во свайпов//
  while (driver.findElements(by).size() ==0)   // цикл будет работать пока функция не найдет не одного элемента
  {


    if (already_swiped > max_swipes) {
      waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
      return;
    }
      swipeUpQuick();
      ++already_swiped;
    }
  }


  protected void swipeElementToLeft(By by,String error_message)
  {
    WebElement element = waitForElementPresent(
            by,
            error_message,
            10);

    int left_x = element.getLocation().getX();
    int right_x = left_x + element.getSize().getWidth();
    int upper_y = element.getLocation().getY();
    int lower_y = upper_y + element.getSize().getHeight();
    int middle_y = (upper_y + lower_y)/2;

    TouchAction action = new TouchAction(driver);
    action.
            press(right_x,middle_y)
            .waitAction(300).
            moveTo(left_x,middle_y).
            release().
            perform();
  }
   private int getAmoundOfElements(By by)
   {
     List elements = driver.findElements(by);
     return  elements.size();
   }


   private void assertElementNotPresent(By by, String error_message)
   {
     int amount_of_elements = getAmoundOfElements(by);
     if (amount_of_elements > 0)
     {
       String default_message = "An element' " +  by.toString() + "'supposed to be not present";
       throw new AssertionError(default_message + " " + error_message);
     }

   }

   private  String waitForElementAndGetAttribute (By by, String attribute, String error_message, long timeoutInSeconds)
   {
     WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
     return  element.getAttribute(attribute);
   }



}

