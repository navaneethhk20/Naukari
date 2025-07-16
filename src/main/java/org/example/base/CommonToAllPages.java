package org.example.base;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public CommonToAllPages(){

    }
    public void openNaukari(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by){
       by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }
    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

    public void visibiltyOfElement(By elementLocation, String key){
       new WebDriverWait(getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation)).sendKeys(key);
    }
    public void presenceOfElement(By elementLocation, String key){
         new WebDriverWait(getDriver(),Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(elementLocation)).sendKeys(key);
    }

    public void visibiltyOfElement(By elementLocation){
        new WebDriverWait(getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void visibiltyOfElementAndClick(By elementLocation){
        new WebDriverWait(getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation)).click();
    }
    public WebElement presenceOfElement(By elementLocation){
        new WebDriverWait(getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
        return null;
    }
    

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public void customWait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
