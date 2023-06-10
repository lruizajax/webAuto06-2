package com.nopcommerce.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps {

    ChromeDriver driver;
    int TIME_OUT= 20;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        //headless
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
    }

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        driver.get("https://demo.nopcommerce.com/login");
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String user, String pass) {
        driver.findElement(By.id("Email")).sendKeys(user);
        driver.findElement(By.id("Password")).sendKeys(pass);
    }
    @When("User click on Login Button")
    public void user_click_on_login_button() {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).submit();;
    }
    @Then("The account option should be displayed")
    public void the_account_option_should_be_displayed() {
        //assertion
        WebElement linkLogOut = new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log out")));

        //assertEquals(linkAccount.getText(),"My account");
        assertEquals("Invalid Credentials","Log out", linkLogOut.getText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
