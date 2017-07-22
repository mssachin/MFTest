package com.mftest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Sachin on 22/07/2017.
 */
public class GoogleSearchResultsPage {

    private WebDriver driver;
    private static final By linkLocator = By.tagName("a");
    private static final String pageNumberLocatorStart = "//*[@id='nav']/tbody/tr/td[";
    private static final String pageNumberLocatorEnd = "]/a";
    private static final By searchResultsPanelLocator = By.id("center_col");

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void extractLinkTextAndClick(String requiredLink) throws InterruptedException {
        int pageNumberInit =3;

        boolean foundMatch = false;
        while (!foundMatch) {
            WebElement resultsPanel = driver.findElement(searchResultsPanelLocator);
            List<WebElement> linkElements = resultsPanel.findElements(linkLocator);


            for (int i = 0; i < linkElements.size(); i++) {
                String linkURL =linkElements.get(i).getText();
                if (linkURL.contains(requiredLink)) {
                    Thread.sleep(5000L);
                    WebElement wWait = (new WebDriverWait(driver, 10))
                            .until(ExpectedConditions.elementToBeClickable(By.linkText(linkElements.get(i).getText())));
                    Actions action  = new Actions(driver);
                    action.click(wWait).build().perform();
                    foundMatch = true;
                    break;
                }else if(i==linkElements.size()-1 & !(linkURL.contains(requiredLink))){
                    String pgId = String.valueOf(pageNumberInit);
                    WebElement nextPageElement = driver.findElement(By.xpath(pageNumberLocatorStart+pgId+pageNumberLocatorEnd));
                    Actions action  = new Actions(driver);
                    action.click(nextPageElement).build().perform();
                    pageNumberInit++;
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }else{
                    continue;
                }

            }


        }


    }


}

