package appclick.pageObjects.OtherObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SMSObjects extends PageObject {

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'МТС')]")
    private AndroidElement titleFromMTS;
////a[contains(@href,'logout.aspx')]
    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'1126')]")
    private AndroidElement titleFromBeeline;

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'МКС')]")
    private AndroidElement smsTextFromBeeline;

    @AndroidFindBy (xpath = "//android.widget.TextView[contains(@text,'Googames']")
    private AndroidElement smsTextFromMTS;

    public SMSObjects(AppiumDriver driver) {
        super(driver);
    }

    public String getSMSText(String currentOperator){
    if (currentOperator.contains("MTS")){
        return getSMSTextDependingOnOperator(titleFromMTS,smsTextFromMTS);
    }
    else if (currentOperator.contains("Beeline")){
        return getSMSTextDependingOnOperator(titleFromBeeline,smsTextFromBeeline);
    }
    else if (currentOperator.contains("Tele2")){
        return null;
    }
    else{return null;}
    }

    public String getSMSTextDependingOnOperator(AndroidElement title,AndroidElement smsText){
        try {
            wait.until(ExpectedConditions.visibilityOf(title)).click();
            return wait.until(ExpectedConditions.visibilityOf(smsText)).getText();}
            catch (Exception e) {
                return null;
            }
        }
}
