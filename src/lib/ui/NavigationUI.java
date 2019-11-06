package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {


  protected static String
     MY_LISTS_LINK;

                  //="xpath://android.widget.FrameLayout[@content-desc='My lists']";



  public NavigationUI (AppiumDriver driver)
  {
    super(driver);
  }

  public void clickMyLists ()
  {
  this.waitForElementAndClick(
            MY_LISTS_LINK, // из аппиум берем class и content-desc
            "Cannot find navigation button to 'My lists'", // не находим кнопку Му лист
            5);
  }


}
