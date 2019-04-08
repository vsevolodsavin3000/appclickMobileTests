package appclick;

import appclick.tests.SubscriptionTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import appclick.tests.CheckSMS;

@RunWith(JUnitPlatform.class)
@SelectClasses({SubscriptionTest.class})
public class TestSuite {
}
//mvn surefire:test -Dtest=src/test/java/partnership/TestSuitePartners.java

