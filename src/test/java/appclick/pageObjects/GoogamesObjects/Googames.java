package appclick.pageObjects.GoogamesObjects;

import appclick.pageObjects.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Googames extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='se.appland.appclick_publisher:id/next']")
    private AndroidElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='se.appland.appclick_publisher:id/done']")
    private AndroidElement doneButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement categoryButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Остросюжетные\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private AndroidElement ostrosujetnieButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
    private AndroidElement firstGame;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='se.appland.appclick_publisher:id/download_button_text']")
    private AndroidElement installButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='НАЧАТЬ ИГРАТЬ']")
    private AndroidElement startPlayingButton;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Открыть панель навигации']")
    private AndroidElement navigationMenuButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Вступить в клуб']")
    ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.CheckedTextView
    private AndroidElement joinClubButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='Номер карты']")
    private AndroidElement askForBankCard;

    public Googames(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public AndroidElement getNextButton(){
        return nextButton;
    }

    public void pressNextThreeTimesOnStart()   {
        wait.until(ExpectedConditions.visibilityOf(getNextButton())).click();
        wait.until(ExpectedConditions.visibilityOf(getNextButton())).click();
        wait.until(ExpectedConditions.visibilityOf(getDoneButton())).click();
    }

    public AndroidElement getDoneButton() {
        return doneButton;
    }

    public AndroidElement getCategoryButton() {
        return categoryButton;
    }

    public AndroidElement getOstrosujetnieButton() {
        return ostrosujetnieButton;
    }

    public AndroidElement getFirstGame() {
        return firstGame;
    }

    public AndroidElement getInstallButton() {
        return installButton;
    }

    public AndroidElement getStartPlayingButton() {
        return startPlayingButton;
    }

    public AndroidElement getNavigationMenuButton() { return navigationMenuButton; }

    public AndroidElement getJoinClubButton() { return joinClubButton;}

    public AndroidElement getAskForBankCard() { return askForBankCard; }

    public void pressCategoryButton(){
        wait.until(ExpectedConditions.visibilityOf(getCategoryButton())).click();
    }

    public void pressOstrosujetnieButton(){
        wait.until(ExpectedConditions.visibilityOf(getOstrosujetnieButton())).click();
    }

    public void pressFirstGameButton(){
        wait.until(ExpectedConditions.visibilityOf(getFirstGame())).click();
    }

    public void pressInstallButton(){
        wait.until(ExpectedConditions.visibilityOf(getInstallButton())).click();
    }

    public void pressStartPlayingButton(){
        wait.until(ExpectedConditions.visibilityOf(getStartPlayingButton())).click();
    }

    public boolean checkIfAlreadySubscribed(){
        wait.until(ExpectedConditions.visibilityOf(getNavigationMenuButton())).click();
        try{
            //Thread.sleep(5000);
            String joinClubText = getJoinClubButton().getText();
            System.out.println(joinClubText);
            if (joinClubText.equals("Вступить в клуб")||joinClubText.equals("Join a club")){
                return false;
            }
            else return true;
            //smallWait.until(ExpectedConditions.elementToBeClickable(getJoinClubButton())); хз почему не работает!!!
        }
        catch (Exception e){
            System.out.println(e);
            return true;
        }
    }
    public boolean checkAskingForBankCardIfNotSupportedOperatorOrNoSim(){
        try {
            wait.until(ExpectedConditions.visibilityOf(getAskForBankCard()));
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

}
