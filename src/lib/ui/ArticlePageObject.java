package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

  private  static final String
          TITLE = "id:org.wikipedia:id/view_page_title_text",
          FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
          OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
          OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Find in page']",
          ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
          MY_LiST_NAME_IMPUT = "id:org.wikipedia:id/text_input",
          MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
          CLOSE_ARTIKLE_BUTTON= "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
          OPEN_CREATED_LIST = "xpath:org.wikipedia:id/item_title";


  public  ArticlePageObject (AppiumDriver driver)
  {
    super(driver);
  }

  public WebElement waitForTitleElement()
  {
    return this.waitForElementPresent(TITLE,"Cannot find article title on page",10);
  }

  public String getArticleTitle()
  {
    WebElement title_element = waitForTitleElement();
    return  title_element.getAttribute("text");

  }

  public void swipeToFooter()
  {
    this.swipeUpToFindElement(
            FOOTER_ELEMENT,
            "Cannot find the end of article",
            20);
  }

  public void addArticleToMyList(String name_of_folder)
  {
    this.waitForElementAndClick(
            OPTIONS_BUTTON,   // из аппиум берем class и content-desc
            "Cannot find button to open article options ", // кнопка опции - три точки в правом вверхнем углу
            5 );

    this.waitForElementAndClick(
            OPTIONS_ADD_TO_MY_LIST_BUTTON, // в кнопке опции клик по 'Add to reading list'
            "Cannot find option to 'Add to reading list'",
            5);

    this.waitForElementAndClick(
            ADD_TO_MY_LIST_OVERLAY, // из аппиум берем resource-id кнопки
            "Cannot find button 'GOT IT'",
            5);

    this.waitForElementAndClear(
        MY_LiST_NAME_IMPUT,
        "Cannot find input to set name of articles folder", // очищаем текст
        5);


    this.waitForElementAndSendKeys(
            MY_LiST_NAME_IMPUT,
            name_of_folder ,   // "Learning Programming"
            "Cannot put text into articles folder input",  // ввод значения в строку, наименование папки "Learning Programming"
            5);

    this.waitForElementAndClick(
            MY_LIST_OK_BUTTON,  //нажимаем кнопку "ок"
            " Cannot press 'OK' button",
            5);

  }


  public void addSecondArticleToMyList(String name_of_folder) {
    this.waitForElementAndClick(
            OPTIONS_BUTTON,   // из аппиум берем class и content-desc
            "Cannot find button to open article options ", // кнопка опции - три точки в правом вверхнем углу
            5);

    this.waitForElementAndClick(
            OPTIONS_ADD_TO_MY_LIST_BUTTON, // в кнопке опции клик по 'Add to reading list'
            "Cannot find option to 'Add to reading list'",
            5);

    this.waitForElementAndClick(
            OPEN_CREATED_LIST, // из аппиум берем resource-id кнопки, клик по листу выбранному
            "Cannot find button 'Learning Programming'",
            5);

  }




  public void closeArticle()
  {
    this.waitForElementAndClick(
            CLOSE_ARTIKLE_BUTTON, // из аппиум берем class и content-desc нашла кнопку с помощью App Sourse  в аппиум
            "Cannot close article, cannot find X link", // не находим кнопку X (слева вврху)
            5);
  }


}
