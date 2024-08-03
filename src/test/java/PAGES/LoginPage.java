package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By LogoLocator = By.cssSelector("img[class='login-website-logo']");
    By HeadingLocator = By.xpath("//h1[@class='sign-in-heading']");
    By UserNameLabelLocator = By.xpath("//label[contains(text(),'USER')]");
    By PasswordLabelLocator = By.xpath("//label[contains(text(),'PASS')]");
    By LoginButtonLocator = By.className("login-button");
    By UsernameLocator = By.id("usernameInput");
    By PasswordLocator = By.id("passwordInput");
    By ErrorMessageLocator = By.className("error-message");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement Logo(){
        return  driver.findElement(LogoLocator);
    }
    public String Heading(){
        return driver.findElement(HeadingLocator).getText();
    }
    public String UsernameLabel(){
        return driver.findElement(UserNameLabelLocator).getText();
    }
    public String PasswordLabel(){
        return driver.findElement(PasswordLabelLocator).getText();
    }
    public void LoginButton(){
        driver.findElement(LoginButtonLocator).click();
    }
    public WebElement loginButtonIsDisplayedOrNot(){
        return driver.findElement(LoginButtonLocator);
    }
    public void UsernameInputField(String username){
        driver.findElement(UsernameLocator).sendKeys(username);
    }
    public void PasswordInputField(String password){
        driver.findElement(PasswordLocator).sendKeys(password);
    }

    public void Credentials(String username,String password){
        UsernameInputField(username);
        PasswordInputField(password);
        LoginButton();
    }

    public String errorMessage(){
        return driver.findElement(ErrorMessageLocator).getText();
    }




}
