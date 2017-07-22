package com.mftest.stepdefinitions;

import com.mftest.base.TestBase;
import com.mftest.pageobjects.AmazonIPhonePage;
import com.mftest.pageobjects.GoogleHomePage;
import com.mftest.pageobjects.GoogleSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sachin on 22/07/2017.
 */
public class SearcBasedOnKeyWordDefinition extends TestBase {

    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private AmazonIPhonePage amazonIPhonePage;

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


    @Then("^in the search results I look for a specific \"([^\"]*)\" and click on it$")
    public void in_the_search_results_I_look_for_a_specific(String requiredLink) throws Throwable {
        googleSearchResultsPage.extractLinkTextAndClick(requiredLink);
        String currentURL =driver.getCurrentUrl();
        System.out.println("Current URL is "+currentURL);
        amazonIPhonePage = new AmazonIPhonePage(driver);

    }

    @Then("^I verify the link details$")
    public void i_verify_the_link_details() throws Throwable {
        String priceAndName =amazonIPhonePage.clickOnHighestMemoryDeviceAndReturnPriceAndName();
        String[] individualString = priceAndName.split(" ");
        String devicePrice = individualString[0];
        String deviceName = individualString[1];
        String[] priceSplit = devicePrice.split("£");
        String devicePriceAsNumber =priceSplit[1];
        double priceDouble = Double.parseDouble(devicePriceAsNumber);
        System.out.println("Device Name is "+deviceName);
        System.out.println("Device Price is "+devicePrice);
        Assert.assertTrue("Device Price is more than 800", priceDouble<800  );



    }




}
