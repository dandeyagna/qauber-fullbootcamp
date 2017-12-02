package Tests;
import Pages.HeaderPage;
import Pages.MainNavigationPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOpenProfilePanel extends LoginTest {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;

    @Test(dependsOnMethods = "testLogin")
    public void testProfilePanelIsVisible() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage =new ProfilePanelPage(driver);
        //assert that profile panel is displayed when clicking on user link
        Assert.assertTrue(profilePanelPage.getProfilePanelDisplayed().isDisplayed());
        mainNavigationPage = new MainNavigationPage(driver);
        Thread.sleep(2000);
        mainNavigationPage.clickAddReportLink();
        //assert that profile panel disappear when clicking on any page button
        Assert.assertFalse(profilePanelPage.getProfilePanelDisplayed().isDisplayed());

    }
    @Test(dependsOnMethods = "testLogin")
    public  void testIconsChangeColor() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage =new ProfilePanelPage(driver);
        profilePanelPage.clickSubscriptionIcon();
        Assert.assertTrue(profilePanelPage.getSubscriptionIconActive().isEnabled());
        Thread.sleep(2000);
        profilePanelPage.clickUserIcon();
        Assert.assertTrue(profilePanelPage.getProfileIconActive().isEnabled());
    }
}
