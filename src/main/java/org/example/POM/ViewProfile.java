package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewProfile{

    WebDriver driver;

    public ViewProfile(WebDriver driver) {
    this.driver =driver;
    }

    private By updateResume = By.xpath("//input[@value=\"Update resume\"]");

    public void clickViewProfile(){
        driver.findElement(DashboardPage.viewProfileButton).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickonupdatedResume(){
        driver.findElement(updateResume).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
