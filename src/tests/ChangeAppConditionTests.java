package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase
{
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
//            "Cannot find 'Search Wikipedia' input",
//            5);
//
//    driver.runAppInBackground(2);
//
//    MainPageObject.waitForElementPresent(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find article after returning from background",
//            5);

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");

    this.backgraundApp(2);

    SearchPageObject.waitForSearchResult("Object-oriented programming language");

  }



}
