package appclick.pageObjects.OtherObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MiscObjects extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.mediatek.filemanager:id/edit_adapter_name']")
    private AndroidElement internalStorage;

    @AndroidFindBy(xpath = "//android.widget.TextView[text()='Download']")
    private AndroidElement downloadFolder;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout")
    private AndroidElement apk;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/ok_button']")
    private AndroidElement installButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/launch_button']")
    private AndroidElement launchButton;

    public MiscObjects(AppiumDriver driver) {
        super(driver);
    }

    public void initInstall() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(installButton)).click();
        Thread.sleep(3000);
        longWait.until(ExpectedConditions.visibilityOf(launchButton));
    }
}
