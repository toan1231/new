package nbcUniversalPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MainHomePage {
    WebDriver driver;
    public MainHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//*[@id='homePrimaryMainNav']/li[1]/a")
    public WebElement homeButton;
    @FindBy(xpath = "//*[@id='homePrimaryMainNav']/li[2]/a")
    public WebElement aboutButton;
    @FindBy(xpath = "//*[@id='homePrimaryMainNav']/li[3]/a")
    public WebElement historyButton;
    @FindBy(xpath = "//*[@id='site-holder']/header/button[1]/img")
    public WebElement sandwichButton;
    @FindBy(xpath = "//*[@id='homePrimaryMainNav']/li")
    public List<WebElement>mainMenuHeadline;



}
