package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver(){
    }
    private static Driver instance=new Driver();
    public static Driver getInstance(){
        return instance;
    }
    ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>();
    public WebDriver getDriver(){
        return driver.get();
    }
    public  void setDriver(WebDriver dr){
           driver.set(dr);
    }
  public void removeDriver(){
      // driver.get().quit();
      // driver.remove();
  }
}
