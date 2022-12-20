package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;

    @Given("Login page is opened")
    public void openLoginPage(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.play1.automationcamp.ir/login.html");
    }

    @When("login credentials are entered")
    public void enterLoginCredentials(){
        type(By.id("user"), "test_login");
        type(By.id("password"), "test_pwd");
    }

    @When("specific login credentials are entered")
    public void enterSpecificLoginCredentials(DataTable table){
        List<Map<String, String>> dataTable = table.asMaps();

        String login = dataTable.get(0).get("current_login");
        String pwd = dataTable.get(0).get("current_password");

        type(By.id("user"), login);
        type(By.id("password"), pwd);
    }
    private void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @And("Login button is clicked")
    public void clickLoginBtn(){
        click(By.id("login"));
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    @Then("error message appears")
    public void assertErrorMsg(){
        String actualErrorMsgText = getText(By.id("message"));
        Assert.assertEquals("Error message appears","Incorrect username or password. Try again!!",actualErrorMsgText);
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}
