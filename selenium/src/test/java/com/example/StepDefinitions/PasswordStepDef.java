package com.example.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Base64;

public class PasswordStepDef {

    static WebDriver driver;

    @Before
    public void startDriver(){
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }


    @Given("user logs in with Patient credentials")
    public void user_logs_in_with_patient_credentials() {
        driver.get("http://my-doctors.net/auth/login");
        driver.manage().window().maximize();
        Base64.Decoder decoder = Base64.getDecoder();
        String dStr = new String(decoder.decode("SkZDQVVJWlhAZ21haWwuY29t"));
        driver.findElement(By.id("emailOrMobile")).sendKeys(dStr);

        Base64.Decoder decoder1 = Base64.getDecoder();
        String Password = new String(decoder1.decode("QXNkeEAzNHY="));
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@tabindex='2']")).click();

    }
    @Given("user navigates to Change Password")
    public void user_navigates_to_change_password() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(".//*[text()='Account Settings']")).click();
        driver.findElement(By.xpath(".//*[text()='Change Password']")).click();
    }

    @When("^user enters value (.*) in the current password input field$")
    public void currentPassword(String Current_Password) {
        driver.findElement(By.name("currentPassword")).sendKeys(Current_Password);
    }

    @When("^user enters value (.*) in the new password input field$")
    public void newPassword(String New_Password) {
        driver.findElement(By.cssSelector("div.MuiFormControl-root.MuiTextField-root:nth-child(2) input")).sendKeys(New_Password);
    }

    @When("^user enters value (.*) in confirm_password input field$")
    public void confirmPassword(String Confirm_Password) {
        driver.findElement(By.cssSelector("div.MuiFormControl-root.MuiTextField-root:nth-child(3) input")).sendKeys(Confirm_Password);
    }

    @When("^user clicks on submit button$")
    public void submit_button() {
        driver.findElement(By.xpath(".//*[@value='Submit']")).click();
    }

    @Then("^user can view the message (.*)$")
    public void message(String Error_Message) {
        driver.findElement(By.xpath(".//*[text()='"+Error_Message+"']")).isDisplayed();
    }
}
