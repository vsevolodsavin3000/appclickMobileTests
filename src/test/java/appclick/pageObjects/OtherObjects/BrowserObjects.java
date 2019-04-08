package appclick.pageObjects.OtherObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserObjects extends PageObject {

    @FindBy(className = "android.widget.RadioButton")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[1]")
    private WebElement searchEngineRadioButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button")
    private AndroidElement okButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private AndroidElement nextButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
    private AndroidElement downloadButton;

    @AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    private  AndroidElement allowButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[2]")
    private AndroidElement okButton2;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.chrome:id/snackbar_button']")
    private AndroidElement openButton;

/*    @FindBy(xpath = "//*[contains(text(),'СКАЧАТЬ')]")
    private WebElement downloadButton;*/

    @FindBy(xpath ="//*[contains(text(),'Загрузить Goo Games')]" )
    //@AndroidFindBy(xpath = "//android.view.View[contains(text(),'Загрузить Goo Games')]")
    private WebElement loadButton;

    public BrowserObjects(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectSearchEngine(){
        wait.until(ExpectedConditions.visibilityOf(searchEngineRadioButton)).click();
        okButton.click();
    }

    public void downloadGoogames(){//514 1244
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();

    }
    public void pressNextButton(){
        wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
    }
    public void pressAllowButton(){
        wait.until(ExpectedConditions.visibilityOf(allowButton)).click();
    }
    public void pressDownloadButton(){
        wait.until(ExpectedConditions.visibilityOf(downloadButton)).click();
    }
    public void pressOkButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(okButton2)).click();
        Thread.sleep(3000);
        longWait.until(ExpectedConditions.visibilityOf(openButton)).click();
    }
}
