package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTest extends CoreTestCase
{
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

}
