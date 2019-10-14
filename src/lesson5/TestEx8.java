package lesson5;


import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;


public class TestEx8 extends CoreTestCase {

  private MainPageObject MainPageObject;

  protected void setUp() throws Exception
     {
       super.setUp();

       MainPageObject = new MainPageObject(driver);
     }

  @Test
  public void testSearch() {

//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//    MainPageObject.waitForElementPresent(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Object-oriented programming language' topic searchink by 'Java'",
//            15);

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");

  }


  @Test
  public void testCancelSearch() {
//    MainPageObject.waitForElementAndClick(
//            By.id("org.wikipedia:id/search_container"),
//            "Cannot find 'Search Wikipedia' input",
//            5
//    );
//
//    MainPageObject. waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);

//    MainPageObject.waitForElementAndClear(
//            By.id("org.wikipedia:id/search_src_text"),
//            "Cannot find search field",
//            5);
//
//
//    MainPageObject.waitForElementAndClick(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "Cannot find X to cancel 'Search'",
//            5
//
//    );
//
//    MainPageObject.waitForElementNotPresent(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "X is still present on the page",
//            5
//
//    );

    /*Ex 3*/

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.waitForCanselButtonToAppear();
    SearchPageObject.clickCancelSearch();
    SearchPageObject.waitForCanselButtonToDisappear();

  }

  @Test
  public void testCompareArticleTitle(){
//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    WebElement title_element = MainPageObject.waitForElementPresent(
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

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String article_title = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
            "We see unexpected title",
            "Java (programming language)",
            article_title);

  }

  @Test
  public void testSwipeArticle(){
//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Appium",
//            "Cannot find search input",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']"),
//            "Cannot find 'Appium' article in Search",
//            5);
//
//    MainPageObject.waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//            "Cannot find 'Article Title'",
//            15);
//
//
//    MainPageObject.swipeUpToFindElement(
//    By.xpath("//*[@text='View page in browser']"),
//            "Cannot find the end of the article",
//            15);

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.swipeToFooter();


  }


  @Test
  public  void testSaveFirstArticleToMyList()    // сохранение в лист
  {
//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    MainPageObject.waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),  // ищем название текста (хедер) по resource-id
//            "Cannot Article Title",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//android.widget.ImageView[@content-desc='More options']"),   // из аппиум берем class и content-desc
//            "Cannot find button to open article options ", // кнопка опции - три точки в правом вверхнем углу
//            5 );
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@text='Add to reading list']"), // в кнопке опции клик по 'Add to reading list'
//            "Cannot find option to 'Add to reading list'",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.id("org.wikipedia:id/onboarding_button"), // из аппиум берем resource-id кнопки
//            "Cannot find button 'GOT IT'",
//            5);
//
//    MainPageObject.waitForElementAndClear(
//        By.id("org.wikipedia:id/text_input"),
//        "Cannot find input to set name of articles folder", // очищаем текст
//        5);
//
//
//   String name_of_Folder = "Learning Programming";
//
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.id("org.wikipedia:id/text_input"),
//            name_of_Folder ,   // "Learning Programming"
//            "Cannot put text into articles folder input",  // ввод значения в строку, наименование папки "Learning Programming"
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@text='OK']"),  //нажимаем кнопку "ок"
//            " Cannot press 'OK' button",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), // из аппиум берем class и content-desc нашла кнопку с помощью App Sourse  в аппиум
//            "Cannot close article, cannot find X link", // не находим кнопку X (слева вврху)
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), // из аппиум берем class и content-desc
//            "Cannot find navigation button to 'My lists'", // не находим кнопку Му лист
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@text='"+ name_of_Folder +"']"), // из аппиум берем text   "//*[@text='Learning Programming']"
//            "Cannot find created folder", // не находим список 'Learning Programming'
//            5);
//
////    waitForElementPresent(
////            By.id("org.wikipedia:id/item_container"),  // ищем название текста (хедер) по resource-id
////            "Cannot find folder",
////            5);
//
//    MainPageObject.swipeElementToLeft(
//              By.xpath("//*[@text='Java (programming language)']"), // из аппиум берем text
//              "Cannot find saved article" );         // не находим в списке 'Learning Programming' -Java (programming language)
//
//
//    MainPageObject.waitForElementNotPresent(
//            By.xpath("//*[@text='Java (programming language)']"), // из аппиум берем text
//            "Cannot delete saved  article",
//            5);

    /*Ex 5*/

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    ArticlePageObject.waitForTitleElement();
    String article_title = ArticlePageObject.getArticleTitle();
    String name_of_folder = "Learning Programming";
    ArticlePageObject.addArticleToMyList(name_of_folder);
    ArticlePageObject.closeArticle();

    /* добавляем 2ю статью в лист */

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addSecondArticleToMyList(name_of_folder);
    ArticlePageObject.closeArticle();


    NavigationUI NavigationUI = new NavigationUI(driver);
    NavigationUI.clickMyLists();

    MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
    MyListPageObject.openFolderByName(name_of_folder);
    MyListPageObject.swipeByArticleToDelete(article_title);

  }

  @Test
  public void testAmountOfNotEmptySearch()
  {
//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    String search_line = "Linking Park discography";
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            search_line,
//            "Cannot find search input",
//            5);
//
//    String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_title']";   // resource_id для родителя и затем для доченего элемента
//
//    MainPageObject.waitForElementPresent(
//            By.xpath(search_result_locator),
//            "Cannot find anything by the request" + search_line,
//            15);
//
////
//    int amount_of_search_results = MainPageObject.getAmoundOfElements(
//            By.xpath(search_result_locator)
//    );
//
//    Assert.assertTrue(
//            "We found too few results!",
//            amount_of_search_results>0
//    );

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    String search_line = "Linking Park discography";
    SearchPageObject.typeSearchLine(search_line);
    int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertTrue(
            "We found too few results!",
            amount_of_search_results>0 );

  }

  @Test
  public void testAmountOfEmptySearch ()
  {
//    MainPageObject.waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    String search_line = "dfdghfjfjfjfj";
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            search_line,
//            "Cannot find search input",
//            5);
//
//    String search_result_locator = "//*[@resource_id='org.wikipedia:id/search_results_list']/*[@resource_id='org.wikipedia:id/page_list_item_title']";   // resource_id для родителя и затем для доченего элемента
//    String empty_result_label = "//*[@text='No results found']";
//
//    MainPageObject.waitForElementPresent(
//            By.xpath(empty_result_label),
//            "Cannot find empty result label by the request" + search_line,
//            15);
//
//    MainPageObject.assertElementNotPresent(
//            By.xpath(search_result_locator),
//            "We've found some results by request" + search_line);

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    String search_line = "dfdghfjfjfjfj";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.waitForEmptyResultsLabel();
    SearchPageObject.assertThereIsNotResultOfSearch();

  }

  @Test
  public  void testAssertElementPresent ()
  {
//    waitForElementAndClick(
//            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    String search_line = "Park";
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            search_line,
//            "Cannot find search input",
//            5);

//    String search_result_locator = "//*[@resource-id ='org.wikipedia:id/search_results_list']/*[@resource-id = 'org.wikipedia:id/page_list_item_container']";   // resource_id для родителя и затем для доченего элемента
//
//    waitForElementPresent(
//            By.xpath(search_result_locator),
//            "Cannot find anything by the request" + search_line,
//            15);
//
//    int amount_of_search_results = getAmoundOfElements(
//            By.xpath(search_result_locator)
//    );

//    Assert.assertTrue(
//            "We found too few results!",
//            amount_of_search_results>0
//    );
//
//    waitForElementAndClick(
//            By.xpath(search_result_locator),
//            "Cannot find Article title",
//            10);
        /*Ex 6 */
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    String search_line = "Park";
    SearchPageObject.typeSearchLine(search_line);

    int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertTrue(
            "We found too few results!",
            amount_of_search_results > 0 );

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    ArticlePageObject.openArticle();

  }

  @Test
  public  void testChangeScreenOrientationOnSearchResults ()
  {
//    driver.rotate(ScreenOrientation.PORTRAIT);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    String search_line = "Java";
//
//    MainPageObject.waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            search_line,
//            "Cannot find search input",
//            5);
//
//    MainPageObject.waitForElementAndClick(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'Object-oriented programming language' topic searching by" + search_line,
//            15);
//
//    String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
//            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
//           "text",
//            "Cannot find  title of article",
//            15);
//
//     driver.rotate(ScreenOrientation.LANDSCAPE);
//
//    String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
//            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
//            "text",
//            "Cannot find  title of article",
//            15);
//
//
//    Assert.assertEquals(
//            "Article title have been changed after screen rotation",
//            title_before_rotation,title_after_rotation);
//
//    driver.rotate(ScreenOrientation.PORTRAIT);
//
//    String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
//            By.id("org.wikipedia:id/view_page_title_text"),   // resourse-id  берем
//            "text",
//            "Cannot find  title of article",
//            15);
//
//    Assert.assertEquals(
//            "Article title have been changed after screen rotation",
//            title_before_rotation,title_after_second_rotation);
    /*Ex 7*   */
    this.rotateScreenPortrait();

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String title_before_rotation = ArticlePageObject.getArticleTitle();

    this.rotateScreenLandscape();
    String title_after_rotation = ArticlePageObject.getArticleTitle();
    Assert.assertEquals(
            "Article title have been changed after screen rotation",
            title_before_rotation,title_after_rotation);

    this.rotateScreenPortrait();
    String title_after_second_rotation = ArticlePageObject.getArticleTitle();
    Assert.assertEquals(
            "Article title have been changed after screen rotation",
            title_before_rotation,title_after_second_rotation);
  }


  @Test
  public void testCheckSearchArticleInBackground ()
  {
    MainPageObject.waitForElementAndClick(
            By.xpath ("//*[contains(@text,'Search Wikipedia')]"),
            "Cannot find 'Search Wikipedia' input",
            5);

    MainPageObject.waitForElementAndSendKeys(
            By.xpath("//*[contains(@text,'Search…')]"),
            "Java",
            "Cannot find search input",
            5);

    MainPageObject.waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find 'Search Wikipedia' input",
            5);

    driver.runAppInBackground(2);

    MainPageObject.waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "Cannot find article after returning from background",
            5);

  }






}

