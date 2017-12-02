package Tests;

import Pages.EditProfilePage;
import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import Data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeNameTest extends LoginTest {

    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;
    private HeaderPage headerPage;
    @BeforeMethod
    public void beforeMethod(){
    }

    @Test(dependsOnMethods = "testLogin", dataProviderClass = DataProviders.class,dataProvider= "ChangeName")
    public void testChangeName(String name){

        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();

        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditProfileBtn();

        editProfilePage = new EditProfilePage(driver);
        editProfilePage.setNameField(name);
        editProfilePage.clickUpdateNameBtn();
        String successMessage = editProfilePage.getSuccessMessage();
        Assert.assertEquals(successMessage, "The profile has been updated.");
        headerPage.clickLogo();
    }
    @Test(dependsOnMethods = "testLogin")
    private void testErrorForChangeName(){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.setNameField(" ");
        editProfilePage.clickUpdateNameBtn();
        String requiredError = editProfilePage.getErrorRequired();
        Assert.assertEquals(requiredError, "This field is required");
        headerPage.clickLogo();
    }
}
