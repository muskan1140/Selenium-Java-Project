package com.example.StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature", glue= {"com.example.StepDefinitions"})
public class TestRunnerTest {
}