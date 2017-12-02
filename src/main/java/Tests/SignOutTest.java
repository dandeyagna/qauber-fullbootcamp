package Tests;

import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends LoginTest {
    private ProfilePanelPage profilePanelPage;
    private LoginPage loginPage;
    private HeaderPage headerPage;

    @Test(dependsOnMethods = "testLogin")
    public void testSignOut(){
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickSignOut();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getSignInToContinue().isDisplayed());
    }
}
