import PAGES.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    WebDriverWait wait;
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void LoginPageUI(){
        Assert.assertTrue(loginPage.Logo().isDisplayed());
        Assert.assertEquals(loginPage.Heading(),"Login");
        Assert.assertEquals(loginPage.UsernameLabel(),"USERNAME");
        Assert.assertEquals(loginPage.PasswordLabel(),"PASSWORD");
        System.out.println(loginPage.loginButtonIsDisplayedOrNot().isDisplayed());
    }
    @Test(priority = 2)
    public void LoginFunctionalityWithEmptyInputField(){
        loginPage.Credentials("","");
    }
    @Test(priority = 3)
    public void LoginFunctionalityWithEmptyUsername(){
        loginPage.Credentials("","rahul@2021");
    }
    @Test(priority = 4)
    public void LoginFunctionalityWithEmptyPassword(){
        loginPage.Credentials("rahul","");
    }
    @Test(priority = 5)
    public void LoginFunctionalityInvalidCredentials(){
        loginPage.Credentials("rahul","rahul2021");
    }
    @Test(priority = 6)
    public void LoginFunctionalityWithValidCredentials(){
        loginPage.Credentials("rahul","rahul@2021");
    }



}
