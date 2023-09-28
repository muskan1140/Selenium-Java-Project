package com.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.lang.reflect.Type;

import static com.example.StepDefinitions.PasswordStepDef.driver;

public class DoctorRegistrationStepDef {


    @Given("^user navigates to the Doctor Registration page$")
    public void user_navigates_to_the_doctor_registration_page() {
        driver.get("http://my-doctors.net/auth/doctor-register");
        driver.manage().window().maximize();
    }

    @When("^user enters value (.*) in the full name input field$")
    public void userEnterValue(String Name) {
        driver.findElement(By.id("full_name")).sendKeys(Name);
    }

    @When("^user selects checkbox with value (.*)$")
    public void user_selects_checkbox_with_value(String Gender_Type) {
        driver.findElement(By.name("gender")).click();
    }

    @When("^user enters value (.*) in the email input field$")
    public void user_enters_value_in_the_email_input_field(String Email) {
        driver.findElement(By.id("email_address")).sendKeys(Email);
    }

    @When("^user enters value (.*) in the mobile number input field$")
    public void user_enters_value_in_the_mobile_number_input_field(String Mobile_Number) {
        driver.findElement(By.id("mobile_number")).sendKeys(Mobile_Number);
    }
    @When("^user enters value (.*) in the create password input field$")
    public void user_enters_value_in_the_create_password_input_field(String Password) {
        driver.findElement(By.id("password")).sendKeys(Password);
    }
    @When("^user enters value (.*) in the confirm password input field$")
    public void user_enters_value_in_the_confirm_password_input_field(String Password) {
        driver.findElement(By.id("confirm_password")).sendKeys(Password);
    }

    @When("^user clicks on the register button$")
    public void user_clicks_on_the_register_button() {
        driver.findElement(By.xpath(".//*[text()='Register']")).click();
    }

    @Then("^user can view message Signed up successfully!$")
    public void message() {
        driver.findElement(By.xpath(".//*[text()='Signed up successfully']")).isDisplayed();
    }

    @Then("^user can view message the (.*)$")
    public void message(String Error_Message) {
        driver.findElement(By.xpath(".//*[text()='"+Error_Message+"']")).isDisplayed();
    }

}