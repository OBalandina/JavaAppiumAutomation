package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {

                TITLE = "id:org.wikipedia:id/view_page_title_text";
                FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
                OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
                OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Find in page']";
                ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
                MY_LiST_NAME_IMPUT = "id:org.wikipedia:id/text_input";
                MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
                CLOSE_ARTIKLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
                OPEN_CREATED_LIST = "xpath:org.wikipedia:id/item_title";
    }

    public  AndroidArticlePageObject (AppiumDriver driver)
    {super(driver);}

}
