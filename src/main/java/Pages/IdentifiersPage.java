package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentifiersPage {
    public IdentifiersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[label/text()='Tattoos']/div/span/label/span")
    WebElement checkTattoos;
    @FindBy(xpath = "//div[label/text()='Tattoos']/div/input")
    WebElement insertTattoos;
    @FindBy(xpath = "//div[label/text()='Scars']/div/span/label/span")
    WebElement checkScars;
    @FindBy(xpath = "//div[label/text()='Scars']/div/input")
    WebElement insertScars;
    @FindBy(xpath = "//div[label/text()='Needle Marks']/div/span/label/span")
    WebElement checkNeedleMarks;
    @FindBy(xpath = "//div[label/text()='Needle Marks']/div/input")
    WebElement insertNeedleMarks;
    @FindBy(xpath = "//div[label/text()='Tracks']/div/span/label/span")
    WebElement checkTracks;
    @FindBy(xpath = "//div[label/text()='Tracks']/div/input")
    WebElement insertTracks;
    @FindBy(xpath = "//div[label/text()='Glasses']/div/span/label/span")
    WebElement checkGlasses;
    @FindBy(xpath = "//div[label/text()='Glasses']/div/input")
    WebElement insertGlasses;
    @FindBy(xpath = "//div[label/text()='Mustache']/div/span/label/span")
    WebElement checkMustache;
    @FindBy(xpath = "//div[label/text()='Mustache']/div/input")
    WebElement insertMustache;
    @FindBy(xpath = "//div[label/text()='Beard']/div/span/label/span")
    WebElement checkBeard;
    @FindBy(xpath = "//div[label/text()='Beard']/div/input")
    WebElement insertBeard;
    @FindBy(xpath = "//div[@ng-show='wizard.active(3)']/ul/li[2]/a")
    WebElement nextButton;

    public void clickNextButton() throws InterruptedException {
        nextButton.click();
    }
    public void checkBoxTattoos(){
        checkTattoos.click();
    }
    public void insertTattoos(String tattoosName){
        insertTattoos.sendKeys(tattoosName);
    }
    public void checkBoxScars(){
        checkScars.click();    }
    public void insertScars(String ScarsName){
        insertScars.sendKeys(ScarsName);
    }
    public void checkNeedleMarks(){
        checkNeedleMarks.click();
    }
    public void insertNeedleMarks(String needleMarksNames){
        insertNeedleMarks.sendKeys(needleMarksNames);
    }
    public void checkTracks(){
        checkTracks.click();
    }
    public void insertTracks(String tracksName){
        insertTracks.sendKeys(tracksName);
    }
    public void checkGlasses(){
        checkGlasses.click();
    }
    public void insertGlasses(String glassesName){
        insertGlasses.sendKeys(glassesName);
    }
    public void checkMustache(){
        checkMustache.click();
    }
    public void insertMustache(String mustacheName){
        insertMustache.sendKeys(mustacheName);
    }
    public void checkBeard(){
        checkBeard.click();
    }
    public void insertBeard(String beardName){
        insertBeard.sendKeys(beardName);
    }

}
