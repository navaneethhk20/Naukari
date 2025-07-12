package org.example.POM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        visibiltyOfElementAndClick(updateResume);
        WebElement upload = getElement(updateResume);
        upload.sendKeys("C:\\Users\\Navaneeth H K\\IdeaProjects\\Naukari\\src\\main\\resources\\Navaneeth H.K.pdf");
    }

    public WebElement resumeUploaded(){
        visibiltyOfElement(successMessage);
        return getElement(successMessage);
    }

}
