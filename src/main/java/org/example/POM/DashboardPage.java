package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage {
     WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//div[@class= \"info__heading\" and contains(text(),\"Navaneeth H K\")]");
    protected static By viewProfileButton = By.xpath("//div[@class=\"view-profile-wrapper\"]");
    private  By lastUpdated = By.xpath("//p[text()=\"Last updated \" and \"1d ago\"]");
    private  By latestUpdated = By.xpath("//p[text()=\"Last updated \" and \"today\"]");


    public String userNameField(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userNameField).getText();
    }
    public  String viewProfileBUtton(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(viewProfileButton).getText();
    }
    public  String latestUpdated(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(latestUpdated).getText();
    }
    public String lastUpdated(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(lastUpdated).getText();
    }
}
