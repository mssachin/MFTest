package com.mftest.stepdefinitions;

import com.mftest.base.TestBase;
import com.mftest.pageobjects.GoogleHomePage;
import com.mftest.pageobjects.GoogleSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sachin on 22/07/2017.
 */
public class SearcBasedOnKeyWordDefinition extends TestBase {

    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private GoogleSearchResultsPage googleSearchResultsPage;

    @Given("^I have launched google homepage$")
    public void i_have_launched_google_homepage() throws Throwable {
        driver = getDriver();

    }

    @When("^I search based on a \"([^\"]*)\" and navigate to search results page$")
    public void i_search_based_on_a_and_navigate_to_search_results_page(String keyword) throws Throwable {
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.searchBasedOnFreeText(keyword);
        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
    }


    @Then("^in the search results I look for a specific \"([^\"]*)\"$")
    public void in_the_search_results_I_look_for_a_specific(String requiredLink) throws Throwable {
        googleSearchResultsPage.extractLinkTextAndClick(requiredLink);

    }



}
