import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PAGES.HomePage;
import PAGES.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void HomePage(){
        loginPage.Credentials("rahul","rahul@2021");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='home-movie-heading']")));
        System.out.println(homePage.homePageHeading());
        System.out.println(homePage.HomePageListHeading1());
        System.out.println(homePage.HomePageListHeading2());
        Assert.assertTrue(homePage.playButtonIsDisplayedOrNot().isDisplayed());
        System.out.println(homePage.listOfMovies());
        Assert.assertTrue(homePage.contactUs().isDisplayed());
    }

}
