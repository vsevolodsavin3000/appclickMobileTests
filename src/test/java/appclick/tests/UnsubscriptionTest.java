package appclick.tests;

import appclick.pageObjects.OtherObjects.SMSObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnsubscriptionTest extends CheckSMS {

    @Test
    @DisplayName("Unsubscribe")
    public void unsubscription(String currentOperator) throws InterruptedException, IOException {
        CheckSMS checkSMS = new CheckSMS();
        checkSMS.checkSMSAfterUnsub(currentOperator);
    }
    public static void main(String args[]) throws IOException, InterruptedException {
        UnsubscriptionTest unsubscriptionTest = new UnsubscriptionTest();
    unsubscriptionTest.unsubscription("Beeline");}
}
