package appclick.tests;

import appclick.ADBCommands.ProcessExecutor;
import appclick.pageObjects.OtherObjects.DialerObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UnsubscribeMTS {
    protected static AppiumDriver<AndroidElement> driver;

    public String unsubscribeMTS() throws IOException, InterruptedException {
        ProcessExecutor processExecutor = new ProcessExecutor();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, processExecutor.getAndroidVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, processExecutor.getDeviceID());
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        //capabilities.setCapability(MobileCapabilityType.APP, "");
        capabilities.setCapability("appPackage","com.android.dialer");
        capabilities.setCapability("appActivity",".app.DialtactsActivity");
        capabilities.setCapability("newCommandTimeout", 2000);
        // capabilities.setCapability("--session-override", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);

        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        DialerObjects dialerObjects = new DialerObjects(driver);
        String smsText = dialerObjects.unsubscribeAndGetText();
/*        SMSObjects smsObjects = new SMSObjects(driver);
        String smsText = smsObjects.getSMSText(currentOperator);*/
        driver.quit();
        return smsText;

    }
}
