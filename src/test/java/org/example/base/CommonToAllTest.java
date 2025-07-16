package org.example.base;

import org.example.POM.LoginPage;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeClass
    public void setUpClass() {
        DriverManager.BrowserInit();
        LoginToNaukari();
    }

    @AfterClass
    public void tearDownClass() {
        DriverManager.tear();
    }


    public void LoginToNaukari(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginTestPositive(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
    }
}
