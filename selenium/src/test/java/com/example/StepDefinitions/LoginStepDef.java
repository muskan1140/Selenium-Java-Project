package com.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Base64;

import static com.example.StepDefinitions.PasswordStepDef.driver;

public class LoginStepDef {
    @Given("^user navigates to the HOMEPAGE$")
    public void user_navigates_to_the_homepage() {
        driver.get("http://my-doctors.net/");
        driver.manage().window().maximize();
    }
    @When("^user clicks element Login$")
    public void user_clicks_element_login() {

        driver.findElement(By.xpath("//*[text()='Login']")).click();
    }
    @When("^user enters the user (.*) in the email input field$")
    public void user_enters_the_user_patient_email_in_the_email_input_field(String email) {
        Base64.Decoder decoder = Base64.getDecoder();
        String dStr = new String(decoder.decode("SkZDQVVJWlhAZ21haWwuY29t"));

        driver.findElement(By.id("emailOrMobile")).sendKeys(dStr);
    }

    @When("^user enters the user (.*) in the password input field$")
    public void user_enters_the_user_patient_password_in_the_password_input_field(String password) {
        Base64.Decoder decoder = Base64.getDecoder();
        String dStr = new String(decoder.decode("QXNkeEAzNHY="));

        driver.findElement(By.id("password")).sendKeys(dStr);
    }

    @When("^user clicks element Login button$")
    public void user_clicks_element_login_button() {
        driver.findElement(By.xpath("//*[@tabindex='2']")).click();
    }

    @Then("^user is on the homepage$")
    public void user_is_on_the_homepage() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://my-doctors.net/auth/login" );
    }

}
