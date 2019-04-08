package appclick.tests;

import appclick.ADBCommands.ProcessExecutor;
import appclick.pageObjects.OtherObjects.SMSObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckSMS {
    protected static AppiumDriver<AndroidElement> driver;

    public String checkSMS() throws InterruptedException, IOException {
        ProcessExecutor processExecutor = new ProcessExecutor();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, processExecutor.getAndroidVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, processExecutor.getDeviceID());
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        //capabilities.setCapability(MobileCapabilityType.APP, "");
        capabilities.setCapability("appPackage","com.android.mms");
        capabilities.setCapability("appActivity",".ui.ConversationList");
        capabilities.setCapability("newCommandTimeout", 2000);
        // capabilities.setCapability("--session-override", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        //capabilities.setCapability("noReset", true);

        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String currentOperator = processExecutor.getOperator();
        SMSObjects smsObjects = new SMSObjects(driver);
        String smsText = smsObjects.getSMSText(currentOperator);
        driver.quit();
        System.out.println(smsText);
        return smsText;
    }
  //  public static void main(String args[]) throws IOException, InterruptedException {new CheckSMS().checkSMS();}
}
