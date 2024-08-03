import PAGES.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PAGES.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SearchPageTest {
    WebDriver driver;
    WebDriverWait wait;
    SearchPage searchPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hemaa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage=new LoginPage(driver);
        searchPage=new SearchPage(driver);
        loginPage.Credentials("rahul","rahul@2021");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-container")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void SearchFunctionality(){
        searchPage.SearchButton();
        searchPage.ValidInput();
        searchPage.SvgButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        System.out.println(searchPage.countOfList());
    }
    @Test(priority = 1)
    public void failureCaseInSearchFunctionality(){
        searchPage.SearchButton();
        searchPage.InvalidInput();
        searchPage.SvgButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("not-found-search-paragraph")));
        System.out.println(searchPage.errorMessageText());
    }

}
