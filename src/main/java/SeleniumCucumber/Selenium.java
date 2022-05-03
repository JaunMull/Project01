package SeleniumCucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jaunz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081");

        driver.manage().window().fullscreen();
        //WebElement searchBox = driver.findElement(By.tagName("input"));
    }
}
