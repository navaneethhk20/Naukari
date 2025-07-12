package org.example.base;

import org.example.POM.LoginPage;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    @BeforeMethod
    public void initialiseBrowser(){
        DriverManager.BrowserInit();
    }


    @AfterMethod
    public void teardown(){
        DriverManager.tear();
    }

    @BeforeMethod
    public void loginset(){
        LoginToNaukari();
    }

    public void LoginToNaukari(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginTestPositive(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
    }
}
