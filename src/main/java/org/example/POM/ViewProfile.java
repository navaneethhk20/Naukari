package org.example.POM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private By updateResume = By.xpath("//input[@value=\"Update resume\"]");
    private By successMessage = By.xpath("//p[text()='Resume has been successfully uploaded.']");

    public void clickViewProfile(){
        visibiltyOfElementAndClick(DashboardPage.viewProfileButton);
    }

    public void clickonupdatedResume(){
        WebElement upload = presenceOfElement(updateResume);
        upload.click();
        visibiltyOfElementAndClick(updateResume);
    }

    public WebElement resumeUploaded(){
        visibiltyOfElement(successMessage);
        return getElement(successMessage);
    }

}
