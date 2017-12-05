package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	WebDriver driver;

	@FindBy(xpath = "//span[@class = 'mr-sm ng-binding']")
	WebElement userProfileNameText;
	@FindBy(xpath = "//a[@class='hidden-xs']")
	WebElement hamBurgerIcon;
	@FindBy(xpath = "//img[@src = 'app/img/logo.png']")
	WebElement brandLogo;
	@FindBy(xpath = "//*[@class='ng-scope']//*[text()='Entities']")
	WebElement entities;
	@FindBy(xpath = "//em[@class='icon-grid']")
	WebElement entitiesIcon;
	@FindBy(xpath = "//a[@class='ng-scope']//*[text()='Users']")
	WebElement users;
	@FindBy(xpath = "//em[@class='icon-user']")
	WebElement usersIcon;
	@FindBy(xpath = "//a[@class='ng-scope']//*[text()='Add Report']")
	WebElement addReports;
	@FindBy(xpath = "//em[@class='icon-doc']")
	WebElement addReportsIcon;
	@FindBy(xpath = "//a[@class='ng-scope']//*[text()='Reports']")
	WebElement reports;
	@FindBy(xpath = "//em[@class='icon-notebook']")
	WebElement reportsIcon;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUserProfileNameText() {
		return userProfileNameText.getText();
	}

	public void clickUserProfileName() {
		userProfileNameText.click();
	}

	public void clickHamBurgerIcon() {
		hamBurgerIcon.click();
	}

	public void clickBrandLogo() {
		brandLogo.click();
	}

	public void clickEntities() {
		entities.click();
	}

	public void clickEntitiesIcon() {
		entitiesIcon.click();
	}

	public void clickUsers() {
		users.click();
	}
	
	public void clickUsersIcon() {
		usersIcon.click();
	}

	public void clickAddReports() {
		addReports.click();
	}

	public void clickAddReportsIcon() {
		addReportsIcon.click();
	}

	public void clickReports() {
		reports.click();
	}

	public void clickReportsIcon() {
		reportsIcon.click();
	}

}
