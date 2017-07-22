package com.mftest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features/GoogleSearchForIPhone.feature",
        glue ="com.mftest.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report"}

)
public class CucumberTestunner {


}
