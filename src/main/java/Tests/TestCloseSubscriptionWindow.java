package Tests;

import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import Pages.SubscriptionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TestCloseSubscriptionWindow extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private SubscriptionsPage subscriptionsPage;
    @BeforeClass
    public void subscriptionBeforeClass() {
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        subscriptionsPage = new SubscriptionsPage(driver);
    }
    @Test(dependsOnMethods = "testLogin")

    public void closeSubscriptionWindowTest() throws InterruptedException {
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        List<WebElement> nr =subscriptionsPage.getAllSubscriptionLinks();
        Iterator<WebElement> iterator =nr.iterator();
        while (iterator.hasNext()){
            iterator.next().click();////Will click on all subscription links
            driver.switchTo().activeElement();
            String x = subscriptionsPage.getDialogMessageText();
            System.out.println(x);
            subscriptionsPage.clickCloseBtn();
            break;
        }
        //can not assert.This pop up window is on html even when is not displayed(in use)
    }
}
