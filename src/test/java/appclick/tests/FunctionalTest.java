package appclick.tests;

import appclick.ADBCommands.ProcessExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static AndroidDriver<AndroidElement> driver;
    protected static AppiumDriver<WebElement> browserDriver;

    @BeforeAll
    public static void setUp() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://chromeDriver/chromedriver.exe");
        ProcessExecutor processExecutor = new ProcessExecutor();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, processExecutor.getAndroidVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, processExecutor.getDeviceID());
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        //capabilities.setCapability(MobileCapabilityType.APP, "");
        capabilities.setCapability("newCommandTimeout", 2000);
        capabilities.setCapability("--session-override", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("noReset", true);
        //capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "se.appland.market.v2.gui.activitys.IntroActivity");
        //capabilities.setCapability("appActivity",".Main");
        //capabilities.setCapability("appPackage","com.android.chrome");
        //capabilities.setCapability("chromeOptions.prefs.distribution.skip_first_run_ui","true");
        //capabilities.setCapability("chromeOptions.prefs.import_search_engine","Google");
/*        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("distribution.import_search_engine", false);
        options.setExperimentalOption("prefs", prefs);*/

        browserDriver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        browserDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void resetBeforeEach(){

    }

    @AfterEach
    public void cleanUp(){

    }

    @AfterAll
    public static void tearDown(){
//        browserDriver.quit();
    }
}