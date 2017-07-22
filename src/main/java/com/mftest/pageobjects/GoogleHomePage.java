package com.mftest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Sachin on 22/07/2017.
 */
public class GoogleHomePage {

    private WebDriver driver;
    private static final By searchBoxLocator = By.id("lst-ib");
    private static final By searchButtonLocator =  By.name("btnG");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public GoogleSearchResultsPage searchBasedOnFreeText(String searchPhrase) throws InterruptedException {
        WebElement searchBoxElement = driver.findElement(searchBoxLocator);
        searchBoxElement.sendKeys(searchPhrase);
        Thread.sleep(3000l);
        WebElement searchButtonElement = driver.findElement(searchButtonLocator);
        searchButtonElement.click();

        return new GoogleSearchResultsPage(driver);

    }

}
