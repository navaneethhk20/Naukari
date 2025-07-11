package org.example.test;

import org.example.POM.LoginPage;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.testng.annotations.Test;

public class LoginToNaukari extends CommonToAllTest {

    @Test
    public void PositiveLoginTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginTestPositive(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
    }

}
