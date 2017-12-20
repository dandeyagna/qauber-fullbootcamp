package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewReports {
    WebDriver driver;
    public ViewReports(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Tattoos']/../span[1]")
    WebElement tattoosSelected;
    @FindBy(xpath = "//span[text()='Scars']/../span[1]")
    WebElement scarsSelected;
    @FindBy(xpath = "//span[text()='Needle Marks']/../span[1]")
    WebElement needleMarksSelected;
    @FindBy(xpath = "//span[text()='Tracks']/../span[1]")
    WebElement tracksSelected;
    @FindBy(xpath = "//span[text()='Glasses']/../span[1]")
    WebElement glassesSelected;
    @FindBy(xpath = "//span[text()='Mustache']/../span[1]")
    WebElement mustacheSelected;
    @FindBy(xpath = "//span[text()='Beard']/../span[1]")
    WebElement beardSelected;
    @FindBy(xpath = "//span[text()='Tattoos']/../div")
    WebElement tattoosVerified;
    @FindBy(xpath = "//span[text()='Scars']/../div")
    WebElement scarsVerified;
    @FindBy(xpath = "//span[text()='Needle Marks']/../div")
    WebElement needleMarksVerified;
    @FindBy(xpath = "//span[text()='Tracks']/../div")
    WebElement tracksVerified;
    @FindBy(xpath = "//span[text()='Glasses']/../div")
    WebElement glassesVerified;
    @FindBy(xpath = "//span[text()='Mustache']/../div")
    WebElement mustacheVerified;
    @FindBy(xpath = "//span[text()='Beard']/../div")
    WebElement beardVerified;
    @FindBy(xpath = "//span[text()='Case ID']/../div")
    WebElement viewPageCaseId;
    public WebElement tattoosIsChecked() {
        return tattoosSelected;
    }
    public WebElement scarsIsChecked() {
        return scarsSelected;
    }
    public WebElement needleMarksIsChecked() {
        return needleMarksSelected;
    }
    public WebElement tracksIsChecked() {
        return tracksSelected;
    }
    public WebElement glassesIsChecked() {
        return glassesSelected;
    }
    public WebElement mustacheIsChecked() {
        return mustacheSelected;
    }
    public WebElement beardIsChecked() {
        return beardSelected;
    }
    public String tattoosVerified(){
        return tattoosVerified.getText();
    }
    public String scarsVerified() {

        return scarsVerified.getText();
    }
    public String needleMarksVerified() {

        return needleMarksVerified.getText();
    }
    public String tracksVerified() {

        return tracksVerified.getText();
    }
    public String glassesVerified() {

        return glassesVerified.getText();
    }
    public String mustacheVerified() {

        return mustacheVerified.getText();
    }
    public String beardVerified() {

        return beardVerified.getText();
    }
    public String viewPageCaseId(){
        return viewPageCaseId.getText();
    }

}
