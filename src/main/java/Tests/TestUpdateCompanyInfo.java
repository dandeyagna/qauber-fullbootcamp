package Tests;

import Data.DataProviders;
import Pages.EditCompanyPage;
import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUpdateCompanyInfo extends BaseTest {
    protected HeaderPage headerPage;
    protected ProfilePanelPage profilePanelPage;
    protected EditCompanyPage editCompanyPage;
    protected LoginPage loginPage;

    @BeforeClass
    public void updateCompanyBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        editCompanyPage = new EditCompanyPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider="updateCompanyInfo",priority = 1)
    public void testUpdateCompanyInfo(String name, String country, String address1, String address2, String city,
                                      String state,String zip,String phone, String email, String notes, String username, String password) throws InterruptedException {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage.setCompanyName(name);
        editCompanyPage.setCountry(country);
        editCompanyPage.setAddress1(address1);
        editCompanyPage.setAddress2(address2);
        editCompanyPage.setCity(city);
        editCompanyPage.setState(state);
        editCompanyPage.setZip(zip);
        editCompanyPage.setPhone(phone);
        editCompanyPage.setEmail(email);
        editCompanyPage.setNotes(notes);
        editCompanyPage.clickUpdateBtn();
        Thread.sleep(3000);

        Assert.assertTrue(editCompanyPage.getSuccessUpdateMessage().isDisplayed());
        headerPage.clickUserLink();
        profilePanelPage.clickSignOut();
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    public void testRequiredFields() throws InterruptedException {
        loginPage.setUsername("buquxahu@cars2.club");
        loginPage.setPassword("kisulea");
        loginPage.clickLoginBtn();
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage.setCompanyName("");
        editCompanyPage.setCountry("Select a country");
        editCompanyPage.setAddress1("");
        editCompanyPage.setAddress2("");
        editCompanyPage.setCity("");
        editCompanyPage.setStateTextField("");
        editCompanyPage.setZip("");
        editCompanyPage.setPhone("");
        editCompanyPage.setEmail("");
        editCompanyPage.setNotes("");
        editCompanyPage.clickUpdateBtn();

        editCompanyPage.getAllRequiredFields();
        int x = editCompanyPage.countRequiredFields();
        System.out.println(x);

        Assert.assertTrue(x==8);//8 fields are required on this form
    }
}
