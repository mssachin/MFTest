package com.mftest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Sachin on 22/07/2017.
 */
public class GoogleSearchResultsPage {

    private WebDriver driver;
    private static final By linkLocator = By.tagName("a");
    private static final String pageNumberLocatorStart = "//*[@id='nav']/tbody/tr/td[";
    private static final String pageNumberLocatorEnd = "]/a";
    private static final By firstPageLocator =   By.xpath("/*[@id='nav']/tbody/tr/td[2");
    private static final By searchResultsPanelLocator = By.id("center_col");

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void extractLinkTextAndClick(String requiredLink) {
        int pageNumberInit =3;

        boolean foundMatch = false;
        while (!foundMatch) {
            WebElement resultsPanel = driver.findElement(searchResultsPanelLocator);
            List<WebElement> linkElements = resultsPanel.findElements(linkLocator);


            for (int i = 0; i < linkElements.size(); i++) {

                System.out.println("Number of Links is "+linkElements.size());

                String linkURL =linkElements.get(i).getText();
                System.out.println("Link Text is " + linkURL);
                if (linkURL.contains(requiredLink)) {
                    linkElements.get(i).click();
                    foundMatch = true;
                    break;
                }else if(i==linkElements.size()-1 & !(linkURL.contains(requiredLink))){


                    String pgId = String.valueOf(pageNumberInit);
                    System.out.println("Page number is "+pageNumberInit);
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

