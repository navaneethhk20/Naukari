package org.example.test;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.example.POM.DashboardPage;
import org.example.POM.LoginPage;
import org.example.POM.ViewProfile;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginToNaukari extends CommonToAllTest {

    @Test
    public void LoginAndVerifyUserDetails(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginTestPositive(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String username = dashboardPage.userNameField();

        String profilebutton = dashboardPage.viewProfileBUtton();
        String lastUpdated= dashboardPage.lastUpdated();
        String latest = dashboardPage.latestUpdated();
        Assert.assertEquals(username,PropertiesReader.readKey("LoggedInuser"));
        Assert.assertEquals(profilebutton, PropertiesReader.readKey(("viewprofile")));
      //  Assert.assertEquals(lastUpdated,PropertiesReader.readKey("lastupdate"));
      //  Assert.assertEquals(latest,PropertiesReader.readKey("latestupdate"));

        ViewProfile viewProfile = new ViewProfile(DriverManager.getDriver());
        viewProfile.clickViewProfile();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewProfile.clickonupdatedResume();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
