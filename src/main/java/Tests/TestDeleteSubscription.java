package Tests;

import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import Pages.SubscriptionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDeleteSubscription extends TestLogin {
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

    public void deleteSubscriptionTest() throws InterruptedException {
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        List<WebElement> nr =subscriptionsPage.getAllSubscriptionLinks();
        int totalNrBeforeDeleting = subscriptionsPage.countAllSubscriptionLinks();//count how many links i have before deleting one of them
        Iterator<WebElement> iterator =nr.iterator();
        while (iterator.hasNext()){
            iterator.next().click();////Will click on all subscription links
            driver.switchTo().activeElement();
            subscriptionsPage.clickCancelSubscriptionBtn();
            Thread.sleep(4000);
            driver.switchTo().activeElement();
            driver.findElement(By.xpath("//button[@ng-click='confirm()']")).click();
           // driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);//i need to work on it.this line of code is not working
            Thread.sleep(24000);//don't know how much page is loading here
            break;
        }
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        List<WebElement> nr2 =subscriptionsPage.getAllSubscriptionLinks();
        int totalNrAfterDeleting = subscriptionsPage.countAllSubscriptionLinks();

        System.out.println("Total Nr. of links Before Deleting: "+totalNrBeforeDeleting + " Total Nr. of links After Deleting: "+totalNrAfterDeleting);

        Assert.assertTrue(totalNrBeforeDeleting>totalNrAfterDeleting);
    }
}
