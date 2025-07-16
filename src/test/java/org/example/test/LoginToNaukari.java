package org.example.test;

import org.example.POM.DashboardPage;
import org.example.POM.ViewProfile;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginToNaukari extends CommonToAllTest {
   @Test
    public void LoginAndVerifyUserDetails() {

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String username = dashboardPage.userNameField();

        String profilebutton = dashboardPage.viewProfileBUtton();
        String lastUpdated = dashboardPage.lastUpdated();

        Assert.assertEquals(username, PropertiesReader.readKey("LoggedInuser"));
        Assert.assertEquals(profilebutton, PropertiesReader.readKey(("viewprofile")));
      //  Assert.assertEquals(lastUpdated,PropertiesReader.readKey("lastupdate"));

    }
    @Test
    public void ResumeUpload() {

        ViewProfile viewProfile = new ViewProfile(DriverManager.getDriver());
        viewProfile.clickViewProfile();
        viewProfile.clickonupdatedResume();

        String successMsg = viewProfile.resumeUploaded().getText();
        Assert.assertEquals(successMsg, PropertiesReader.readKey("successMessage"));

//        String latest = dashboardPage.latestUpdated();
//        Assert.assertEquals(latest,PropertiesReader.readKey("latestupdate"));
    }

}
