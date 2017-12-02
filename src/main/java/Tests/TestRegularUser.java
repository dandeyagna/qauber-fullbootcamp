package Tests;
import Data.DataProviders;
import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.MainNavigationPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegularUser extends BaseTest {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usernamePasswordRU")
    public void regUserTest(String username, String password) throws InterruptedException {
        loginPage= new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(4000);
        mainNavigationPage= new MainNavigationPage(driver);
        Assert.assertTrue(mainNavigationPage.getAddReportLink().isDisplayed());
        Assert.assertTrue(mainNavigationPage.getReportsLink().isDisplayed());
        headerPage =new HeaderPage(driver);
        headerPage.clickUserLink();
        Thread.sleep(4000);
        try {
            profilePanelPage = new ProfilePanelPage(driver);
            Assert.assertFalse(profilePanelPage.getEditCompanyBtn().isDisplayed());
        }catch (Exception TimeoutException){
            //Edit company button is enabled on html page for all users but on UI you can not see it on regular user account
            //Cannot assert that this element is displayed or enabled.It is still there.
            //Time out error because element is not clickable
            System.out.println("Element is not displayed");
        }
        try {
            mainNavigationPage= new MainNavigationPage(driver);
            Assert.assertFalse(mainNavigationPage.getEntitiesLink().isDisplayed(),"If this button is displayed that means it's not a regular user ");
            Assert.assertFalse(mainNavigationPage.getUsersLink().isDisplayed(),"Fail, It's not a regular user");

        }catch (Exception NoSuchElementException){
            System.out.println("NoSuchElementException");
        }


    }
}
