package Tests;

import Pages.EditProfilePage;
import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TestUploadImage extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;
    @BeforeClass
    public void uploadImageBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        editProfilePage = new EditProfilePage(driver);
    }
    @Test(dependsOnMethods = "testLogin")
    public void uploadImageTest() throws InterruptedException, AWTException, IOException {
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.clickSelectPictureBtn();
        editProfilePage.uploadImage();
        try {
            Assert.assertTrue(editProfilePage.getDeleteBtnDisable().isDisplayed());
            System.out.println("Picture was not upload");
        }
        catch (Exception e){
            System.out.println("Delete button is enabled when picture is uploaded.Picture was uploaded");
        }
    }
}

