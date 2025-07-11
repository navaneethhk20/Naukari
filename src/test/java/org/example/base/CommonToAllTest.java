package org.example.base;

import org.example.driver.DriverManager;
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
}
