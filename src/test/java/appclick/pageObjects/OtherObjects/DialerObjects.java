package appclick.pageObjects.OtherObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DialerObjects extends PageObject {

    @AndroidFindBy(id = "com.android.dialer:id/floating_action_button")
    private AndroidElement openKeyboard;

    @AndroidFindBy(id="com.android.dialer:id/digits")
    private AndroidElement editBox;

    @AndroidFindBy(id="com.android.phone:id/input_field")
    private AndroidElement inputField;

    @AndroidFindBy(id="android:id/button1")
    private AndroidElement callButton;

    @AndroidFindBy(id="android:id/message")
    private AndroidElement message;
    public DialerObjects(AppiumDriver driver) {
        super(driver);
    }

    public String unsubscribeAndGetText(){
        wait.until(ExpectedConditions.visibilityOf(openKeyboard)).click();
        wait.until(ExpectedConditions.visibilityOf(editBox)).sendKeys("*152*2#");
        wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys("3");
        wait.until(ExpectedConditions.visibilityOf(callButton)).click();
        return wait.until(ExpectedConditions.visibilityOf(message)).getText();
    }
}
