//package lib;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.lib.ui.ios.IOSDriver;
//import junit.framework.TestCase;
//import org.openqa.selenium.ScreenOrientation;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.URL;
//
//public class iOSTestCase extends TestCase {
//
//    protected AppiumDriver driver;
//
//    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
//
//    @Override
//    protected void setUp() throws Exception
//    {
//        super.setUp();
//
//        DesiredCapabilities Capabilities = new DesiredCapabilities();
//        Capabilities.setCapability("platformName", "iOS");
//        Capabilities.setCapability("deviceName", "iPhone SE");
//        Capabilities.setCapability("platformVersion", "12.1");
//        Capabilities.setCapability("app", "D:\\GitHub\\JavaAppiumAutomation\\apks\\wikipedia.app");
//
//        driver = new IOSDriver(new URL(AppiumURL), Capabilities);
//    }
//
//    @Override
//    public void tearDown() throws Exception
//    {
//        driver.quit();
//
//        super.tearDown();
//    }
//
//    protected void rotateScreenPortrait()
//    {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//    }
//
//    protected void rotateScreenLandscape()
//    {
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//    }
//
//    public class java {
//    }
//}
