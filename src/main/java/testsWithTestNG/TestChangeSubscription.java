package testsWithTestNG;

import pages.HeaderPage;
import pages.PaypalPage;                         //This tests need to be refactored
import pages.ProfilePanelPage;
import pages.SubscriptionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TestChangeSubscription extends LoginTest {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private SubscriptionsPage subscriptionsPage;
    private PaypalPage paypalPage;

    @Test(dependsOnMethods = "testLogin")
    public void subscriptionTest() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickSubscriptionIcon();
        subscriptionsPage = new SubscriptionsPage(driver);

        List<WebElement> nr = subscriptionsPage.getAllSubscriptionLinks();
        Iterator<WebElement> iterator = nr.iterator();
        while (iterator.hasNext()) {
            iterator.next().click();////Will click on all subscription links
            driver.switchTo().activeElement();
            subscriptionsPage.changeNrOfUsersDragDrop();
            Thread.sleep(5000);
            subscriptionsPage.clickChangeSubBtn();
            Thread.sleep(14000);
            paypalPage = new PaypalPage(driver);
            paypalPage.paypalSwitchAndPay();//payment for adding new users
            Thread.sleep(15000);
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));
            break;
        }
    }

    @Test(dependsOnMethods = "testLogin")
    public void closeSubscriptionWindowTest() {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickSubscriptionIcon();
        subscriptionsPage = new SubscriptionsPage(driver);
        List<WebElement> nr = subscriptionsPage.getAllSubscriptionLinks();
        Iterator<WebElement> iterator = nr.iterator();
        while (iterator.hasNext()) {
            iterator.next().click();////Will click on all subscription links
            driver.switchTo().activeElement();
            String x = subscriptionsPage.getDialogMessageText();
            System.out.println(x);
            subscriptionsPage.clickCloseBtn();
            break;
        }
        //can not assert.This pop up window is on html even when is not displayed(in use)
    }

    @Test(dependsOnMethods = "testLogin")

    public void deleteSubscriptionTest() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        subscriptionsPage = new SubscriptionsPage(driver);
        List<WebElement> nr = subscriptionsPage.getAllSubscriptionLinks();
        int totalNrBeforeDeleting = subscriptionsPage.countAllSubscriptionLinks();//count how many links i have before deleting one of them
        Iterator<WebElement> iterator = nr.iterator();
        while (iterator.hasNext()) {
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
        List<WebElement> nr2 = subscriptionsPage.getAllSubscriptionLinks();
        int totalNrAfterDeleting = subscriptionsPage.countAllSubscriptionLinks();

        System.out.println("Total Nr. of links Before Deleting: " + totalNrBeforeDeleting + " Total Nr. of links After Deleting: " + totalNrAfterDeleting);

        Assert.assertTrue(totalNrBeforeDeleting > totalNrAfterDeleting);
    }
}
