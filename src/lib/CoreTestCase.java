package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;


public class CoreTestCase extends TestCase {

//  private static final  String PLATFORM_IOS = "lib/ui/ios";
//  private static final  String PLATFORM_ANDROID = "android";

  protected AppiumDriver driver;

  @Override
  protected void setUp() throws Exception
  {
    super.setUp();
    driver = Platform.getInstance().getDriver();
    this.rotateScreenPortrait();
    this.skipWelcomePagForIOSApp();
  }

   @Override
  public void tearDown() throws Exception
  {
    driver.quit();

    super.tearDown();
  }

  protected void rotateScreenPortrait()
  {
    driver.rotate(ScreenOrientation.PORTRAIT);
  }

  protected void rotateScreenLandscape()
  {
    driver.rotate(ScreenOrientation.LANDSCAPE);
  }

  protected void backgroundApp (int seconds)
  {
    driver.runAppInBackground(seconds);
  }

  private  void skipWelcomePagForIOSApp()
  {
   if (Platform.getInstance().isIOS()) {
     WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
     WelcomePageObject.clickSkip();
   }
  }

}
