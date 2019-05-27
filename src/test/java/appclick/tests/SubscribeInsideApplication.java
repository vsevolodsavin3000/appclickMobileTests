package appclick.tests;

import appclick.ADBCommands.ProcessExecutor;
import appclick.pageObjects.GoogamesObjects.Googames;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class SubscribeInsideApplication {
    protected static AppiumDriver<AndroidElement> GGdriver;


    public void subscribeGoogames(String currentOperator) throws InterruptedException, IOException {
        ProcessExecutor processExecutor = new ProcessExecutor();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, processExecutor.getAndroidVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, processExecutor.getDeviceID());
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        //capabilities.setCapability(MobileCapabilityType.APP, "");
        capabilities.setCapability("appPackage","se.appland.appclick_publisher");
        capabilities.setCapability("appActivity","se.appland.market.v2.gui.activitys.LaunchActivity");
        capabilities.setCapability("newCommandTimeout", 2000);
       // capabilities.setCapability("--session-override", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        //capabilities.setCapability("noReset", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "se.appland.market.v2.gui.activitys.IntroActivity");

        GGdriver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        GGdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Googames googames = new Googames(GGdriver);
        try {
            googames.pressNextThreeTimesOnStart();
            if(googames.checkIfAlreadySubscribed()){
                fail("УЖЕ БЫЛ ПОДПИСАН");
            }
            GGdriver.navigate().back();
            googames.pressCategoryButton();
            googames.pressOstrosujetnieButton();
            googames.pressFirstGameButton();
            googames.pressInstallButton();
            //Dimension windowSize = GGdriver.manage().window().getSize();
            //Thread.sleep(40000);
            //new TouchAction<>(GGdriver).tap(PointOption.point(windowSize.width/2,windowSize.height/3)).perform();
            if (currentOperator.contains("MTS")||currentOperator.contains("Beeline")||currentOperator.contains("Tele2")) {
                try {
                    googames.pressStartPlayingButton();
                }
                catch (Exception e){
                    fail("Land didn't open within 1 minute   "+e);
                }
            }
            else{
                if(googames.checkAskingForBankCardIfNotSupportedOperatorOrNoSim()){
                    //спросил банковскую карту если не поддерживается оператор или нет сим карты
                }
                else fail("DID NOT ASK BANK CARD(unsupported operator or no sim)");
            }
            Thread.sleep(10000);
            //1280-  720-
        }
        catch (Exception e){
            System.out.println(e);
            fail("Something gone wrong");
        }
        finally {
            GGdriver.removeApp("se.appland.appclick_publisher");
        }
        GGdriver.quit();
    }
}

