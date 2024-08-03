import PAGES.HomePage;
import PAGES.LoginPage;
import PAGES.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import java.time.Duration;

public class PopularPageTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage=new HomePage(driver);
        popularPage=new PopularPage(driver);
        loginPage.Credentials("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.home-movie-details-container")));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void PopularPageUI(){
        popularPage.popularPageNavigation();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-movies-container")));
        Assert.assertEquals(popularPage.PopularPageMovies(),30,"Popular page movies are loaded successfully.");
    }
}
