package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import nbcUniversalPages.FirstHomePage;
import nbcUniversalPages.CareerPage;
import nbcUniversalPages.MainHomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class nbcUniversalStepDefinitionStep {
    WebDriver driver= Driver.getInstance().getDriver();


    MainHomePage mainHomePage = new MainHomePage(driver);
    CareerPage careerPage=new CareerPage(driver);
    @Given("User launches the webpage")
    public void user_launches_the_webpage() {

    driver.get(ConfigurationReader.getProperty("nbcUniversal.properties","nbcUniversal.url"));
    }

    @When("User clicks on the sandwich button")
    public void user_clicks_on_the_sandwich_button() throws InterruptedException {

        List<WebElement>mainMenu=mainHomePage.mainMenuHeadline;
        for(int a=0;a<mainMenu.size();a++){
            if(a==0){
                continue;
            }
            mainMenu.get(a).click();
            Thread.sleep(1000);
        }
    }
    @Then("User could see all the major functionalities  of first homepage")
    public void user_could_see_all_the_major_functionalities_of_first_homepage(List<String>mainMenu) {

        List<WebElement>actualMainMenu=mainHomePage.mainMenuHeadline;
        for(int a=1;a<actualMainMenu.size();a++){
            String actualMenuItem=actualMainMenu.get(a).getText();
            String expectedMainMenuItem=mainMenu.get(a);
            Assert.assertEquals("its wrong",expectedMainMenuItem,actualMenuItem);
        }
    }
    @Then("User should see all the main menu on career page")
    public void user_should_see_all_the_main_menu_on_career_page(List<String>careerMainMenu) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    List<WebElement>actualMainMenu=mainHomePage.mainMenuHeadline;
    actualMainMenu.get(6).click();
    //driver.findElement(By.xpath("//*[@id=\"homePrimaryMainNav\"]/li[3]/a")).click();
        String parent=driver.getWindowHandle();
        Set<String >allWindows=driver.getWindowHandles();
        for(String child:allWindows){
            if(!child.equals(parent)){
                driver.switchTo().window(child);
            }
        }
     CareerPage careerPage=new CareerPage(driver);
        List<WebElement>careerMenu=careerPage.maimMenuCareer;
        for(int a=0;a<careerMenu.size()-1;a++){
            String expected=careerMainMenu.get(a);
            String actual=careerMenu.get(a).getText();
            Assert.assertEquals("",actual,expected);
            careerMenu.get(a).click();
            Thread.sleep(1000);
            JavascriptExecutor st=(JavascriptExecutor)driver;
            st.executeScript("arguments[0].scrollIntoView();",
                    driver.findElement(By.xpath("//*[@id=\"page\"]/footer/" +
                            "div/div[2]/section/a/img")));
        }
    }
}
