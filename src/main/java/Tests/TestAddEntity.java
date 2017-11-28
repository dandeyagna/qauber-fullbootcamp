package Tests;

import Data.DataProviders;
import Pages.EntitiesPage;
import Pages.MainNavigationPage;
import Pages.PaypalPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddEntity extends TestLogin {
    private MainNavigationPage mainNavigationPage;
    private EntitiesPage entitiesPage;
    private PaypalPage paypalPage;
    @BeforeClass
    public void entityBeforeClass(){
        mainNavigationPage = new MainNavigationPage(driver);
        entitiesPage = new EntitiesPage(driver);
        paypalPage = new PaypalPage(driver);
    }
    @Test(dependsOnMethods = "testLogin", dataProviderClass = DataProviders.class, dataProvider = "addEntityInfo")
    public void testAddEntity(String name,String country,String address1, String city, String state,
                              String zip, String phone, String email, String RUemail, String AUemail) throws InterruptedException {
        mainNavigationPage.clickEntitiesLink();
        entitiesPage.clickAddEntityBtn();
        entitiesPage.setCompanyName(name);
        entitiesPage.setCountry(country);
        entitiesPage.setAddress1(address1);
        entitiesPage.setCity(city);
        entitiesPage.setState(state);
        entitiesPage.setZip(zip);
        entitiesPage.setPhone(phone);
        entitiesPage.setEmail(email);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.setAddEmailRU(RUemail);
        entitiesPage.clickNextStepBtn();
        entitiesPage.setAddEmailFieldAU(AUemail);
        entitiesPage.clickNextStepBtn();
        entitiesPage.clickFinishBtn();
        Thread.sleep(20000);
        paypalPage.paypalSwitchAndPay();
        Thread.sleep(10000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));
    }
}
