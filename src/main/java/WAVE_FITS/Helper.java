package WAVE_FITS;

import TestResources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Helper {
    WebDriver driver;
    PageResources pageResources;
    private int value;

    public Helper(WebDriver driver) {
        this.driver = driver;
        pageResources = new PageResources(driver);

    }

    public void login() throws InterruptedException {
        driver.get("http://fits.qauber.com/#/page/login");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        pageResources.getLoginpage().userNamefield().sendKeys("cubo@nada.ltd");
        pageResources.getLoginpage().userPassword().sendKeys("abcdefgh");
       Thread.sleep(1000);
        pageResources.getLoginpage().loginButton();
    }

    public void selectingEntity() throws InterruptedException {
        /*WebElement addReport1 = driver.findElement(By.xpath("//a[@class ='hidden-xs']/em"));
        addReport1.click();
        Thread.sleep(1000);*/
        WebElement addReport = driver.findElement(By.xpath("//span[text()='Add Report']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addReport);
        addReport.click();
        Thread.sleep(1000);
        pageResources.getAddingEntity().selectingEntity().click();
        pageResources.getAddingEntity().clickNextButton();
    }

    public void creatingSubjectInfo() {
        Random rand = new Random();
        value = rand.nextInt(1000);
        pageResources.getCreatingSubjectInformation().caseID().sendKeys(String.valueOf(value));
        pageResources.getCreatingSubjectInformation().lastName().sendKeys("sam" + value);
        pageResources.getCreatingSubjectInformation().FirstName().sendKeys("samual");
        pageResources.getCreatingSubjectInformation().clickNextButton();
    }

    public void creatingIdInfo() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getCreatingIDInformation().clickNextButton();
    }

    public void creatingDistribution() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getCreatingDistribution().locationOfStop().sendKeys("Santa Clara");
        pageResources.getCreatingDistribution().clickNextButton();
    }

    public void creatingVehicle() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getVehicalDetails().clickNextButton();
    }

    public void addPhoto() {

        pageResources.getAddPhotos().clickNextButton();
    }

    public void publishReport() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getCreatePublishReport().clickPublishReport();
    }

    public void testCase1() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase2() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkBoxTattoos().click();
        pageResources.getIdentifiersPage().insertTattoos().sendKeys("Dragon");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase3() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkBoxScars().click();
        pageResources.getIdentifiersPage().insertScars().sendKeys("Mole");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase4() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkNeedleMarks().click();
        pageResources.getIdentifiersPage().insertNeedleMarks().sendKeys("On Leg");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase5() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkTracks().click();
        pageResources.getIdentifiersPage().insertTracks().sendKeys("On Hand");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase6() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkGlasses().click();
        pageResources.getIdentifiersPage().insertGlasses().sendKeys("Yes");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase7() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkMustache().click();
        pageResources.getIdentifiersPage().insertMustache().sendKeys("Yes");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase8() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkBeard().click();
        pageResources.getIdentifiersPage().insertBeard().sendKeys("Yes");
        pageResources.getIdentifiersPage().clickNextButton();
    }

    public void testCase9() throws InterruptedException {
        Thread.sleep(500);
        pageResources.getIdentifiersPage().checkBoxTattoos().click();
        pageResources.getIdentifiersPage().insertTattoos().sendKeys("Dragon");
        pageResources.getIdentifiersPage().checkBoxScars().click();
        pageResources.getIdentifiersPage().insertScars().sendKeys("Mole");
        pageResources.getIdentifiersPage().checkNeedleMarks().click();
        pageResources.getIdentifiersPage().insertNeedleMarks().sendKeys("On Leg");
        pageResources.getIdentifiersPage().checkTracks().click();
        pageResources.getIdentifiersPage().insertTracks().sendKeys("On Hand");
        pageResources.getIdentifiersPage().checkGlasses().click();
        pageResources.getIdentifiersPage().insertGlasses().sendKeys("Yes");
        pageResources.getIdentifiersPage().checkMustache().click();
        pageResources.getIdentifiersPage().insertMustache().sendKeys("Yes");
        pageResources.getIdentifiersPage().checkBeard().click();
        pageResources.getIdentifiersPage().insertBeard().sendKeys("Yes");
        pageResources.getIdentifiersPage().clickNextButton();

    }
    public void testCase10() throws InterruptedException {
        Thread.sleep(500);
        if(pageResources.getIdentifiersPage().insertTattoos().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkBoxTattoos().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertScars().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkBoxScars().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertNeedleMarks().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkNeedleMarks().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertTracks().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkTracks().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertGlasses().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkGlasses().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertMustache().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkMustache().isSelected());
        }
        if(pageResources.getIdentifiersPage().insertBeard().isDisplayed()==false){
            Assert.assertFalse(pageResources.getIdentifiersPage().checkBeard().isSelected());
        }
        pageResources.getIdentifiersPage().clickNextButton();

    }
  public void selectingDriver(){
        WebElement selectDriver= pageResources.getCreatingSubjectInformation().SelectingDriver();
        selectDriver.click();
        if (selectDriver.isSelected()==true) {

        }

    }
    public void selectingPassenger(){
        pageResources.getCreatingSubjectInformation().SelectingPassenger();
    }
    public void selectingPedestrian(){
        pageResources.getCreatingSubjectInformation().SelectingPedestrian();
    }

    public void EvaluationPage() throws InterruptedException {
        WebElement reportsPage = driver.findElement(By.xpath("//span[text()='Reports']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reportsPage);
        reportsPage.click();
        Thread.sleep(1000);
        int count = 1;
        String entity= Integer.toString(value);
        while (true) {

            boolean exist = false;

            List<WebElement> allElement = driver.findElements(By.xpath("//em[@title='Case ID']/../span"));
            for (WebElement e : allElement) {
                String b = e.getText();

                if (b.equals(entity)){
                   // System.out.println("//span[text()='"+b+"']/../../div[5]/a[1]");
                    Thread.sleep(1000);
                    WebElement foundCaseId=driver.findElement(By.xpath("//span[text()='"+b+"']/../../div[5]/a[1]"));
                    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
                    foundCaseId.click();

                    exist = true;

                }

                // Assert.assertEquals(exist, true, "Expected email id is not present");
            }
            if (exist==true) {
                break;

            }
            WebElement moveNextButton = driver.findElement(By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']"));
            if(moveNextButton.isDisplayed()){
                count++;
                WebElement page = driver.findElement(By.xpath("//a[text()='"+count+"']"));
                page.click();

            }
            else{
                break;
            }

        }
    }



}



