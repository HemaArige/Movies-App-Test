import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PAGES.HomePage;
import PAGES.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-container")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void MovieDetailsHomePage(){
        homePage.ClickOnAnyMovie();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        System.out.println(homePage.numberOfMoviesDisplayedInHomePage());
        System.out.println(homePage.getMovieTitle());
        System.out.println(homePage.watchTime());
        System.out.println(homePage.sensorRating());
        System.out.println(homePage.releaseYear());
        System.out.println(homePage.movieReview());
        Assert.assertTrue(homePage.playButtonInHomePage().isDisplayed());
    }

    @Test(priority = 1)
    public void MovieDetailsPopularPage(){
        homePage.popularPageNavigation();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        System.out.println(homePage.numberOfMoviesDisplayedInPopularPage());
    }
}
