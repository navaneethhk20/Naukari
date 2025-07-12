package org.example.POM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewProfile extends CommonToAllPages {

    WebDriver driver;

    public ViewProfile(WebDriver driver) {
    this.driver =driver;
    }

    private By updateResume = By.xpath("//input[@value=\"Update resume\"]");

    public void clickViewProfile(){
        visibiltyOfElementAndClick(DashboardPage.viewProfileButton);

    }

    public void clickonupdatedResume(){
        visibiltyOfElementAndClick(updateResume);
    }

}
