package nbcUniversalPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareerPage {
    WebDriver driver;
    public CareerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//*[@id='CollapsingNavbar']/nav/ul/li")
    public List<WebElement>maimMenuCareer;
}
