package org.example.POM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends CommonToAllPages {
     WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static By userNameField = By.xpath("//div[@class= \"info__heading\" and contains(text(),\"Navaneeth H K\")]");
    protected static By viewProfileButton = By.xpath("//div[@class=\"view-profile-wrapper\"]");
    protected static By lastUpdated = By.xpath("//p[text()=\"Last updated \" and \"1d ago\"]");
    protected static By latestUpdated = By.xpath("//p[text()=\"Last updated \" and \"today\"]");


    public String userNameField(){
        customWait();
        return getText(userNameField);
    }
    public  String viewProfileBUtton(){
       customWait();
        return getText(viewProfileButton);
    }
    public  String latestUpdated(){
        customWait();
        return getText(latestUpdated);
    }
    public String lastUpdated(){
        customWait();
        return getText(lastUpdated);
    }
}
