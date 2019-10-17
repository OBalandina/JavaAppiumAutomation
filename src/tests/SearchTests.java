package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
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

    assertTrue(
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

}
