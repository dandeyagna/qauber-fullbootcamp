package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReportsPage {
    public ReportsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement clickOnReports;
    @FindBy(xpath = "//em[@title='Case ID']/../span")
    private List<WebElement> selectingCaseId;
    @FindBy(xpath = "//a[text()='View']")
    private List<WebElement> selectingView;
    @FindBy(xpath = "//a[@ng-click='setCurrent(pagination.current + 1)']/..")
    WebElement findNextPage;
    @FindBy(xpath = "//a[@ng-click='setCurrent(pagination.current + 1)']")
    WebElement clickOnNextPage;
    public void FindReport(String value){
        while (true)
        {

            boolean exist = false;
            for (WebElement e : selectingCaseId)
            {
                String b = e.getText();

                if (b.equals(value)) {
                    int index=selectingCaseId.indexOf(e);
                    selectingView.get(index).click();
                    exist = true;

                }

                // Assert.assertEquals(exist, true, "Expected email id is not present");
            }
            if (exist == true) {
                break;

            }
            try{
              //  moveNextButton=driver.findElement(By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']/.."));
                String attributeValue=findNextPage.getAttribute("class").toString();
                if (attributeValue.equals("ng-scope"))
                {
                    clickOnNextPage.click();

                }

            }catch (Exception e){
                System.out.println("no more pages exist");
                break;
            }
        }
    }
    public void clickOnReport(){
        clickOnReports.click();
    }
}
