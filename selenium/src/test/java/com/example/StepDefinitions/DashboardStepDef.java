package com.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.example.StepDefinitions.PasswordStepDef.driver;
import static org.junit.Assert.assertTrue;

public class DashboardStepDef {

    @Given("^user navigates to Homepage page$")
    public void user_navigates_to_homepage_page() {
        driver.get("http://my-doctors.net/");
        driver.manage().window().maximize();
    }

    @Given("^the corresponding page appears with the expected elements: (.*)$")
    public void the_corresponding_page_appears_with_the_expected_elements_specialities_doctors(String Item) {

        String strMain = Item;
        String[] arrSplit = strMain.split(", ");
        for (String s : arrSplit) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath(".//*[text()='" +s+ "']")).isDisplayed();
        }
    }

    @When("^user clicks on the (.*) card$")
    public void card(String specialityCard) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[text()='" + specialityCard + "']")));
        driver.findElement(By.xpath(".//p[text()='" + specialityCard + "']")).click();
    }

    @Then("^the corresponding page appear with expected elements: (.*)$")
    public void specialities(String Item) {
        driver.findElement(By.id("root")).isDisplayed();
    }

    @When("^user clicks on view all specialities link$")
    public void user_clicks_on_view_all_specialities_link() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("View all Specialities...")).click();
    }

    @Given("^user can view list of doctor cards$")
    public void user_can_view_list_of_doctor_cards() {
        driver.findElement(By.id("doctors")).isDisplayed();
    }

    @Given("^user is on (.*) page$")
    public void user_is_on_page(Integer Page) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='" + Page + "']")));
        WebElement elememt = driver.findElement(By.xpath(".//button[text() ='" + Page + "']"));
        String classEleText = elememt.getAttribute("class");
        assertTrue(classEleText.contains("Mui-selected"));
    }

    @When("^user clicks on the (.*) button$")
    public void user_clicks_on_the_button(Integer Button) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(".//*[text() ='" + Button + "']")).click();
    }

    @Then("^(.*) button is enabled$")
    public void pagination(Integer Second_Button) {
        WebElement elememt1 = driver.findElement(By.xpath(".//button[text() ='" + Second_Button + "']"));
        String classEleText = elememt1.getAttribute("class");
        assertTrue(classEleText.contains("Mui-selected"));
    }

}
