package SeleniumCucumber;

import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {
    public static WebDriver driver;
    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jaunz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/");

        driver.manage().window().fullscreen();
    }
    @When("User Navigate to LogIn Page")
    public void user_navigate_to_log_in_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Title of Page is : " + driver.getTitle());
    }

    @Then("User enters {string} and {string}")
    public void user_enters_and(String username, String pwd) {
        // Write code here that turns the phrase above into concrete actions
        WebElement uname = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));
        uname.sendKeys(username);
        password.sendKeys(pwd);
        try {
            Thread.sleep(2000);
            loginButton.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("User clicks form")
    public void user_clicks_form() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().fullscreen();
        WebElement form = driver.findElement(By.id("File"));
        WebElement pastPend = driver.findElement(By.id("PP"));
        try {
            Thread.sleep(2000);
            form.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User files reimbursement {string} and {string} and {string} and {string}")
    public void user_files_reimbursement_and_and_and(String int1, String string, String int2, String string2) {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().fullscreen();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement eId = driver.findElement(By.id("Id"));
        WebElement fname = driver.findElement(By.id("Fullname"));
        WebElement reim = driver.findElement(By.id("Reimbursement"));
        WebElement reas = driver.findElement(By.id("Reason"));
        WebElement gath = driver.findElement(By.id("gath"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        eId.sendKeys(int1);
        fname.sendKeys(string);
        reim.sendKeys(int2);
        reas.sendKeys(string2);
        js.executeScript("window.scrollBy(0,1000)");
        try {
            Thread.sleep(2000);
            gath.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @And("User clicks cancel")
    public void user_clicks_cancel() {
        driver.manage().window().fullscreen();
        // Write code here that turns the phrase above into concrete actions
        WebElement cancel = driver.findElement(By.id("can"));
        cancel.click();

    }

    @And("User clicks form2")
    public void user_clicks_form2() {
        // Write code here that turns the phrase above into concrete actions
        WebElement pastPend = driver.findElement(By.id("PP"));
        pastPend.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("check submitted forms")
    public void check_submitted_forms() {
        driver.manage().window().fullscreen();
        // Write code here that turns the phrase above into concrete actions
        WebElement getid = driver.findElement(By.id("fortheonetime"));
        getid.click();

    }

    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Login Successful");
        driver.quit();    }
}
