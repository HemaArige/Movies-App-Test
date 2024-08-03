package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.CLASS_NAME,using = "search-empty-button")
    WebElement searchButton;

    @FindBy(how= How.ID,using = "search")
    WebElement searchEl;

    @FindBy(how=How.XPATH,using = "//li[@class='movie-icon-item']")
    List<WebElement> countOfSearchingEl;

    @FindBy(how=How.CLASS_NAME,using = "not-found-search-paragraph")
    WebElement errorMessage;

    @FindBy(how=How.TAG_NAME,using = "svg")
    WebElement svgButtonEl;


    public void SearchButton(){
        searchButton.click();
    }

    public void SvgButton(){
        svgButtonEl.click();
    }

    public void ValidInput(){
        searchEl.sendKeys("in");
    }
    public void InvalidInput(){
        searchEl.sendKeys("Prudhvi");
    }
    public int countOfList(){
        return countOfSearchingEl.size();
    }
    public String errorMessageText(){
        return errorMessage.getText();
    }

}
