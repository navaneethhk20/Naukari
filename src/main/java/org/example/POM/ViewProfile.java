package org.example.POM;

import org.example.base.CommonToAllPages;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ViewProfile extends CommonToAllPages {

    WebDriver driver;

    public ViewProfile(WebDriver driver) {
    this.driver =driver;
    }


    private By updateResumeButton = By.xpath("//span[text()='Upload resume']");
    private By fileInput = By.xpath("//input[@type='file']");
    private By successMessage = By.xpath("//p[text()='Resume has been successfully uploaded.']");
    String path = "C:\\Users\\Navaneeth H K\\IdeaProjects\\Naukari\\src\\main\\resources\\Navaneeth H.K.pdf";
    private By lastupdate = By.xpath("//span[contains(text(),'Today')]");

    public void clickViewProfile(){
        visibiltyOfElementAndClick(DashboardPage.viewProfileButton);
    }

    public void clickonupdatedResume(){
        try {
            uploadFile(fileInput, path);
        } catch (Exception e) {
            customWait();
            clickElement(updateResumeButton);
            visibiltyOfElement(updateResumeButton);
            uploadFile(fileInput, path);
        }
    }

    public WebElement resumeUploaded(){
        presenceOfElement(successMessage);
        return getElement(successMessage);
    }

    public String lastupdated(){
        visibiltyOfElement(lastupdate);
        return getText(lastupdate);
    }

}
