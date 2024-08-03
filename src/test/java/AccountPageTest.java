import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PAGES.LoginPage;
import PAGES.AccountsPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        loginPage.Credentials("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-details-container")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void logoutFunctionality(){
        accountsPage.AvatarImage();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-container")));
        System.out.println(accountsPage.AccountsHeading());
        System.out.println(accountsPage.membershipHeading());
        System.out.println(accountsPage.memberName());
        System.out.println(accountsPage.Password());
        System.out.println(accountsPage.planDetailsHeading());
        System.out.println(accountsPage.planParagraph());
        System.out.println(accountsPage.planDetails());
        accountsPage.logoutButton();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/login"));

    }
}
