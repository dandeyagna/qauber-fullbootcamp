package Tests;

import Pages.EditProfilePage;
import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeleteProfilePicture extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;

    @BeforeClass
    public void deletePictureBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        editProfilePage = new EditProfilePage(driver);
    }
    @Test(dependsOnMethods = "testLogin")
    public void deletePicTest(){

        //precondition for this test : user should have a picture uploaded already
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.clickDeletePictureBtn();
        //for assertion i think i need to show that delete button is disable

        Assert.assertTrue(editProfilePage.getDeleteBtnDisable().isDisplayed());

    }
}

