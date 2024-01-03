package StepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeStepsDefinition {
    private WebDriver driver;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yakaboo.ua/");
    }

    @When("I click the specific element")
    public void i_click_the_specific_element() {
        WebElement element = driver.findElement(By.xpath
                ("/html/body/div[6]/div/div[1]/img"));
        element.click();
    }

    @Then("I am looking for a book")
    public void i_am_looking_for_a_book() {
        ChromeOptions options = new ChromeOptions();
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"site-header\"]//input"));
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        searchBox.sendKeys("Абетка Ольга Павленко");
        searchBox.sendKeys(Keys.ENTER);
        WebElement findButton = driver.findElement(By.xpath
                ("//div [@class=\"ui-search-form-input\"]/button[2]"));
        findButton.click();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yakaboo.ua/ua/search?q=Абетка%20Ольга%20Павленко");
    }

    @When("I am checking the search results")
    public void i_am_checking_the_search_results() {
        assertTrue(driver.findElement(By.xpath
                        ("//*[@id=\"viewport\"]//div[2]/div[2]/div[2]/div/div[1]/div"))
                .isDisplayed());
    }

    @Then("I click on a product")
    public void i_click_on_a_product() {
        driver.findElement(By.xpath
                        ("//*[@id=\"viewport\"]//div[1]/div/div[1]/a/div/img"))
                .click();
        driver.findElement(By.xpath
                        ("//*[@id=\"product\"]//section[1]/div[4]/div[4]/button[2]"))
                .click();
    }

    @When("I should be redirected to the product details page")
    public void i_should_be_redirected_to_the_product_details_page() {
        assertTrue(driver.findElement(By.xpath
                ("//h2[contains(text(),'Оформлення замовлення')]")).isDisplayed());
    }

    @Then("I enter my personal account")
    public void i_enter_my_personal_account() {
        driver.findElement(By.xpath("//*[@id=\"viewport\"]/div[8]/section/div[2]/div[2]/div"))
                .click();
    }

    @When("I enter the email and password")
    public void i_enter_the_email_and_password() {
        ChromeOptions options = new ChromeOptions();
        WebElement emailInput = driver.findElement(By.xpath("//input[@id=\"auth-login\"]"));
        emailInput.sendKeys(Keys.CONTROL + "a");
        emailInput.sendKeys(Keys.DELETE);
        emailInput.sendKeys("work46341@gmail.com");
        emailInput.sendKeys(Keys.ENTER);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"auth-password\"]/div/div[2]/input"));
        passwordInput.sendKeys(Keys.CONTROL + "a");
        passwordInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys("work46341@");
        passwordInput.sendKeys(Keys.ENTER);
        WebElement findButton = driver.findElement(By.xpath
                ("//*[@id=\"viewport\"]/div[8]/div[2]/div/div/div[2]/div/div/button"));
        findButton.click();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yakaboo.ua/ua/checkout");
    }

    public void tearDown() {
        driver.quit();
    }
}

