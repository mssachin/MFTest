package com.mftest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Sachin on 22/07/2017.
 */
public class AmazonIPhonePage {

    private WebDriver driver;
    private static final By highestMemoryDeviceLocator = By.id("a-autoid-9-announce");
    private static final By priceOfDeviceLocator = By.id("priceblock_ourprice");
    private static final By deviceNameLocator = By.id("productTitle");

    public AmazonIPhonePage(WebDriver driver) {
        this.driver = driver;
    }


    public String clickOnHighestMemoryDeviceAndReturnPriceAndName() throws InterruptedException {

        WebElement highestMemoryDeviceElement = driver.findElement(highestMemoryDeviceLocator);
        Thread.sleep(3000L);
        Actions action = new Actions(driver);
        action.click(highestMemoryDeviceElement).build().perform();
        Thread.sleep(5000L);

        WebElement devicePriceElement = driver.findElement(priceOfDeviceLocator);
        String devicePrice = devicePriceElement.getText();

        WebElement deviceNameElement = driver.findElement(deviceNameLocator);
        String deviceName = deviceNameElement.getText();

        return devicePrice+ " "+deviceName;
    }
}
