package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;

public class SubscriptionsPage extends BasePage {
    public SubscriptionsPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//div[@class = 'media bb pl-sm pr-sm ng-scope']/a")
    private List<WebElement> subscriptionLinks;

    @FindBy(xpath = "//div[@class='ngdialog-message']/h2")
    private WebElement dialogMessageGet;
    @FindBy(xpath = "//div[@class='ngdialog-message']")
    private WebElement dialogMessage;

    @FindBy(xpath = "//div[@class='slider-handle min-slider-handle round']")
    private WebElement sliderBtn;
    @FindBy(xpath = "//div[@class='slider slider-horizontal']")
    private WebElement sliderOrizontalBar;
    @FindBy(xpath = "//button[text() = 'CHANGE Subscription']")
    private WebElement changeSubBtn;
    @FindBy(xpath = "//button[text()='CANCEL Subscription']")
    private WebElement cancelSubscriptionBtn;
    @FindBy(xpath = "//button[@type='button' and text()='Close']")
    private WebElement closeBtn;

    public void clickChangeSubBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(changeSubBtn));
        executor.executeScript("arguments[0].click();",changeSubBtn);
    }
    public void clickCloseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }
    public void clickCancelSubscriptionBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelSubscriptionBtn)).click();
    }

    public void changeNrOfUsersDragDrop() throws InterruptedException {
        WebElement sliderBar = sliderOrizontalBar;
        int widthSliderBar = sliderBar.getSize().width;

        WebElement slider = sliderBtn;
        Actions sliderAction = new Actions(driver);
        sliderAction.clickAndHold(slider);
        int x = getPixels(widthSliderBar,60);
        sliderAction.moveByOffset(x, 0).perform();
    }
    public static int getPixels(int totalWidth,int percentage){
        return (int)((totalWidth*percentage)/100);
    }

    public WebElement getDialogMessage() {
        return dialogMessage;
    }
    public String getDialogMessageText(){
        return dialogMessageGet.getText();
    }

    public List<WebElement> getAllSubscriptionLinks() {
        wait.until(ExpectedConditions.visibilityOfAllElements(subscriptionLinks));
        return subscriptionLinks;
    }
    public int countAllSubscriptionLinks(){
        Iterator<WebElement> iterator =subscriptionLinks.iterator();
        int count=0;
        while (iterator.hasNext()){
            count = count+1;
            iterator.next();
        }
        return count;
    }

    public void clickAllSubscriptionLinks(){
        Iterator<WebElement> iterator =subscriptionLinks.iterator();
        while (iterator.hasNext()){
            iterator.next().click();
            //Will click on all subscription links
        }
    }

}
