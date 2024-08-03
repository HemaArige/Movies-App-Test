package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class AccountsPage {
    WebDriver driver;
    WebDriverWait wait;

    public AccountsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    @FindBy(how=How.XPATH,using = "//button[@class='avatar-button']")
    WebElement AvtarImageEl;

    @FindBy(how=How.CLASS_NAME,using = "account-heading")
    WebElement headingOfAccountsPageEl;

    @FindBy(how=How.XPATH,using = "//div[@class='membership-container']//p[@class='membership-heading']")
    WebElement membershipHeadingEl;

    @FindBy(how=How.CSS,using = "p.membership-username")
    WebElement memberNameEl;

    @FindBy(how=How.CLASS_NAME,using = "membership-password")
    WebElement passwordEl;

    @FindBy(how=How.XPATH,using = "//div[@class='plan-container']//p[@class='membership-heading']")
    WebElement planDetailsHeadingEl;

    @FindBy(how=How.CSS,using = "p.plan-paragraph")
    WebElement planParagraphEl;

    @FindBy(how=How.CSS,using = "p.plan-details")
    WebElement planDetailsEl;

    @FindBy(how=How.CSS,using ="button.logout-button")
    WebElement logoutButtonEl;

    public void AvatarImage(){
        AvtarImageEl.click();
    }
    public String AccountsHeading(){
        return headingOfAccountsPageEl.getText();
    }
    public String membershipHeading(){
        return membershipHeadingEl.getText();
    }
    public String memberName(){
        return memberNameEl.getText();
    }
    public String Password(){
        return passwordEl.getText();
    }

    public String planDetailsHeading(){
        return planDetailsHeadingEl.getText();
    }

    public String planParagraph(){
        return planParagraphEl.getText();
    }

    public String planDetails(){
        return planDetailsEl.getText();
    }

    public void logoutButton(){
        logoutButtonEl.click();
    }


}
