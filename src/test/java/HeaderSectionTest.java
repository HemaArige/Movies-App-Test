import PAGES.HomePage;
import PAGES.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class HeaderSectionTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        loginPage.Credentials("rahul","rahul@2021");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.home-movie-details-container")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void HeaderSectionUI(){
        Assert.assertTrue(homePage.imageLogo().isDisplayed());
        System.out.println(homePage.HomeEl());
        System.out.println(homePage.popularEl());
        Assert.assertTrue(homePage.searchImage().isDisplayed());
        Assert.assertTrue(homePage.personImage().isDisplayed());
    }
    @Test(priority = 1)
    public void HeaderSectionFunctionalities(){
        homePage.HomePageNavigation();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#root")));
        homePage.popularPageNavigation();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-movies-container")));
        homePage.accountOfPersonLogo();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.account-information-container")));
    }
}
