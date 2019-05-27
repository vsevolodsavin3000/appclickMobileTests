package appclick.pageObjects.OtherObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static junit.framework.TestCase.fail;

public class SMSObjects extends PageObject {

    @AndroidFindBy(id="com.android.mms:id/unread")
    private AndroidElement titleOfNewUnreadMessage;

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'MTC')]")
    private AndroidElement titleFromMTS;
/*    @AndroidFindBy(accessibility = "com.android.mms:id/text_view")
    private AndroidElement smsTextFromMTS;*/

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'1126')]")
    private AndroidElement titleFromBeeline;
/*    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'stop8')]")
    private AndroidElement smsTextFromBeeline;*/

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'9427')]")
    private AndroidElement titleFromTele2;
    @AndroidFindAll(
            @AndroidBy(id="com.android.mms:id/text_view")
    )
    private List<AndroidElement> smsText;

    public SMSObjects(AppiumDriver driver) {
        super(driver);
    }

    public String getSMSText(String currentOperator){
    if (currentOperator.contains("MTS")){
        return getSMSTextDependingOnOperator(titleFromMTS);
    }
    else if (currentOperator.contains("Beeline")){
        return getSMSTextDependingOnOperator(titleFromBeeline);
    }
    else if (currentOperator.contains("Tele2")){
        return getSMSTextDependingOnOperator(titleFromTele2);
    }
    else return null;
    }

    public String getSMSTextDependingOnOperator(AndroidElement title){
        try {
            longWait.until(ExpectedConditions.visibilityOf(titleOfNewUnreadMessage));
            wait.until(ExpectedConditions.visibilityOf(title)).click();
            return wait.until(ExpectedConditions.visibilityOf(smsText.get(smsText.size()-1))).getText();
        }
            catch (Exception e) {
                fail("No new sms in 5 minutes  "+e);
                return null;
            }
        }
}
