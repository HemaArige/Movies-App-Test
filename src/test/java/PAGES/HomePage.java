package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.XPATH ,using = "//h1[@class='home-movie-heading']")
    @CacheLookup
    WebElement homePageHeadingEl;

    @FindBy(xpath="//h1[@class='movies-list-heading']")
    WebElement homePageListHeadingEl1 ;

    @FindBy(how=How.XPATH,using="//div[@class='home-bottom-container']//div[2]//h1")
    WebElement homePageListHeadingEl2;

    @FindBy(how=How.XPATH,using="//button[@class='home-movie-play-button']")
    WebElement playButtonEl;

    @FindBy(how=How.XPATH,using="//div[@class='home-bottom-container']//div[@class='slick-list']//div[@class='slick-track']//div[@class='slick-slide']")
    List<WebElement> listOfMoviesDisplayedEl;

    @FindBy(how=How.XPATH,using="//p[@class='contact-us-paragraph']")
    WebElement ContactUsEl;

    @FindBy(how=How.CSS,using="img[class='website-logo']")
    WebElement ImageLogoEl;

    @FindBy(how=How.XPATH,using="//a[contains(text(),'Home')]")
    WebElement navbarHomeEl;

    @FindBy(how=How.XPATH,using="//a[@href='/popular']")
    WebElement navbarPopularEl;

    @FindBy(how=How.CSS,using="button.search-empty-button")
    WebElement navbarsearchImageEl;

    @FindBy(how=How.CSS,using="button.avatar-button")
    WebElement navbarPersonLogoEl;

    @FindBy(how=How.XPATH,using = "//a[@class='link-item']")
    WebElement clickOnAnyMovieEl;

    @FindBy(how=How.XPATH,using="//div[@class='title-details-container']/child::h1")
    WebElement movieTitleEl;

    @FindBy(how=How.CSS,using="p.watch-time")
    WebElement watchingTimeEl;

    @FindBy(how=How.CSS,using = "p.sensor-rating")
    WebElement SensorRatingEl;

    @FindBy(how=How.CSS,using = "p.release-year")
    WebElement releaseYearEl;

    @FindBy(how=How.CSS,using = "p.movie-overview")
    WebElement movieReviewEl;

    @FindBy(how=How.CLASS_NAME,using = "play-button")
    WebElement playButtonEl1;

    @FindBy(how=How.XPATH,using = "//img[@class='image-style']")
    List<WebElement> listOfMoviesEl;

    @FindBy(how=How.XPATH,using="//li[@class='movie-icon-item']")
    List<WebElement> listOfMoviesInPopularPage;

    public String homePageHeading(){
        return homePageHeadingEl.getText();
    }

    public String HomePageListHeading1(){
        return homePageListHeadingEl1.getText();
    }

    public String HomePageListHeading2(){
        return homePageListHeadingEl2.getText();
    }

    public WebElement playButtonIsDisplayedOrNot(){
        return playButtonEl;
    }

    public int listOfMovies(){
        return listOfMoviesDisplayedEl.size();
    }

    public WebElement contactUs(){
        return ContactUsEl;
    }

    public WebElement imageLogo(){
        return ImageLogoEl;
    }
    public String HomeEl(){
         return navbarHomeEl.getText();
    }
    public void HomePageNavigation(){
        navbarHomeEl.click();
    }
    public String popularEl(){
        return navbarPopularEl.getText();
    }
    public void popularPageNavigation(){
        navbarPopularEl.click();
    }
    public WebElement searchImage(){
        return navbarsearchImageEl;
    }
    public WebElement personImage(){
        return navbarPersonLogoEl;
    }
    public void accountOfPersonLogo(){
        navbarPersonLogoEl.click();
    }

    public void ClickOnAnyMovie(){
        clickOnAnyMovieEl.click();
    }
    public WebElement playButtonInHomePage(){
        return playButtonEl1;
    }

    public String getMovieTitle(){
        return movieTitleEl.getText();
    }

    public String watchTime(){
        return watchingTimeEl.getText();
    }

    public String sensorRating(){
        return SensorRatingEl.getText();
    }

    public String releaseYear(){
        return releaseYearEl.getText();
    }

    public String movieReview(){
        return movieReviewEl.getText();
    }

    public int numberOfMoviesDisplayedInHomePage(){
        return listOfMoviesEl.size();
    }

    public int numberOfMoviesDisplayedInPopularPage(){
        return listOfMoviesInPopularPage.size();
    }
}















