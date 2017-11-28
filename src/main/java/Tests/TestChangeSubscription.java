package Tests;

import Pages.HeaderPage;
import Pages.PaypalPage;
import Pages.ProfilePanelPage;
import Pages.SubscriptionsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TestChangeSubscription extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private SubscriptionsPage subscriptionsPage;
    private PaypalPage paypalPage;

    @BeforeClass
    public void subscriptionBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage =new ProfilePanelPage(driver);
        subscriptionsPage =new SubscriptionsPage(driver);
        paypalPage=new PaypalPage(driver);

    }
    @Test(dependsOnMethods = "testLogin")

    public void SubscriptionTest() throws InterruptedException {
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        List<WebElement> nr =subscriptionsPage.getAllSubscriptionLinks();
        Iterator<WebElement> iterator =nr.iterator();
        while (iterator.hasNext()){
            iterator.next().click();////Will click on all subscription links
            driver.switchTo().activeElement();
            subscriptionsPage.changeNrOfUsersDragDrop();
            Thread.sleep(5000);
            subscriptionsPage.clickChangeSubBtn();
            Thread.sleep(14000);
            paypalPage.paypalSwitchAndPay();//payment for adding new users
            Thread.sleep(15000);
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));
            break;
       }
    }
}
