package PAGES;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.CSS,using="li.movie-icon-item")
    List<WebElement>  PopularPageEl;

    @FindBy(how=How.XPATH,using="//a[@href='/popular']")
    WebElement navbarPopularEl;


    public int PopularPageMovies(){
        return PopularPageEl.size();
    }
    public void popularPageNavigation(){
        navbarPopularEl.click();
    }

}
