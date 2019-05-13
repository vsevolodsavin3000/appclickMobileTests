package appclick.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PageObject {
    private AppiumDriver<WebElement> driver;
    protected WebDriverWait wait ;
    protected WebDriverWait smallWait ;
    protected WebDriverWait longWait;
    protected ArrayList<String> windows;

    public PageObject(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30,500);
        longWait = new WebDriverWait(driver,300,1000);
        smallWait = new WebDriverWait(driver,3,200);
        windows= new ArrayList<String>();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public PageObject(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30,500);
        longWait = new WebDriverWait(driver,120,1000);
        windows= new ArrayList<String>();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
