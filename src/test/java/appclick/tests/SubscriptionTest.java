package appclick.tests;//import org.junit.*;
import appclick.ADBCommands.ProcessExecutor;
import appclick.pageObjects.OtherObjects.BrowserObjects;
import appclick.pageObjects.OtherObjects.MiscObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

public class SubscriptionTest extends FunctionalTest {


    @Test
    @DisplayName("Install googames by given link and subscribe")
    public void downloadGoogamesByLink() throws IOException, InterruptedException {
        BrowserObjects browserObjects = new BrowserObjects((AppiumDriver<WebElement>) browserDriver);
        //printContextHandlesAndCurrentActivity();
        browserDriver.context("NATIVE_APP");
        browserObjects.selectSearchEngine();
        browserDriver.context("CHROMIUM");
        browserDriver.get("http://googames.org/lp/3549");
        browserDriver.context("NATIVE_APP");
        Dimension windowSize = browserDriver.manage().window().getSize();
        //System.out.println(windowSize.height+" "+windowSize.width);
        new TouchAction<>(browserDriver).tap(PointOption.point(windowSize.width-200,windowSize.height-100)).perform();//чертова кнопка не нажимается по другому
        browserDriver.context("CHROMIUM");
        browserObjects.downloadGoogames();
        browserDriver.context("NATIVE_APP");
        browserObjects.pressNextButton();
        browserObjects.pressAllowButton();
        //browserObjects.pressDownloadButton();
        browserObjects.pressOkButton();
        browserObjects.pressOpenButton(browserDriver);
        MiscObjects miscObjects = new MiscObjects(browserDriver);
        miscObjects.initInstall();
        browserDriver.quit();
        ProcessExecutor processExecutor = new ProcessExecutor();
        String currentOperator = processExecutor.getOperator();
        SubscribeInsideApplication subscribeInsideApplication = new SubscribeInsideApplication();
        subscribeInsideApplication.subscribeGoogames(currentOperator);
        CheckSMS checkSMS = new CheckSMS();
        String smsText = checkSMS.checkSMS(currentOperator);
        if (currentOperator.contains("MTS")) {
            assertEquals("Уважаемый клиент, мы обратили внимание, что вы подключили контентную услугу «Игровой клуб GooGames». Стоимость услуги  10 руб./1 день. Мы заботимся о вас и напоминаем, что управлять контентными услугами вы можете в приложении «Мой МТС» в разделе Услуги mts.ru/app или набрав *152#вызов. \n" +
                    "С заботой, ваш МТС\n", smsText);
        }
        else if(currentOperator.contains("Beeline")){
            assertEquals("Вы активировали подписку на номере 1126, абон. плата 10.01 руб. за 1 день. Сервис предоставляет ООО \"МКС\", 8-800-100-54-10,   help@group-mks.ru. Для отключения услуги отправьте бесплатно stop8 на 1126. Активными подписками управляйте online в Личном кабинете www.beeline.ru/login", smsText);
        }
        else if(currentOperator.contains("Tele2")){
            assertEquals("Вы успешно подписались на услугу Игровой клуб GooGames. Cтоимость подключения 0 руб., абон.плата 10 руб. за 1 дн., с НДС. Провайдер ООО \"МКС\". Для отписки СТОП на номер 9427.",smsText);
        }
        else if(currentOperator == null){
            fail("No SIM");
        }
        else{fail("Not supported mobile operator");}
    }

/*    public void printContextHandlesAndCurrentActivity(){
        Set<String> contextNames = browserDriver.getContextHandles();
        for(String i:contextNames){
            System.out.println(i);
        }
        System.out.println(((AndroidDriver<MobileElement>) browserDriver).currentActivity()+"  "+browserDriver.getContext());
    }*/
}
