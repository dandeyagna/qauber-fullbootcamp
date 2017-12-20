package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddReportsPage {
    public AddReportsPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//span[text()='Add Report']")
    WebElement addingReport;
    public void AddingReports(){
        addingReport.click();
    }
}
