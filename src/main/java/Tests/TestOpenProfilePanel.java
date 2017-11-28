package Tests;

import Pages.HeaderPage;
import Pages.MainNavigationPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOpenProfilePanel extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;
    @BeforeClass
    public void profilePanelBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage =new ProfilePanelPage(driver);
        mainNavigationPage = new MainNavigationPage(driver);

    }
    @Test(dependsOnMethods = "testLogin")
    public void testProfilePanelIsVisible(){
        headerPage.clickUserLink();
        //assert that profile panel is displayed when clicking on user link
        Assert.assertTrue(profilePanelPage.getProfilePanelDisplayed().isDisplayed());
        mainNavigationPage.clickAddReportLink();
        //assert that profile panel disappear when clicking on any page button
        Assert.assertFalse(profilePanelPage.getProfilePanelDisplayed().isDisplayed());

    }
    @Test(dependsOnMethods = "testLogin")
    public  void testIconsChangeColor() throws InterruptedException {
        headerPage.clickUserLink();
        profilePanelPage.clickSubscriptionIcon();
        Assert.assertTrue(profilePanelPage.getSubscriptionIconActive().isEnabled());
        Thread.sleep(2000);
        profilePanelPage.clickUserIcon();
        Assert.assertTrue(profilePanelPage.getProfileIconActive().isEnabled());


    }
}
