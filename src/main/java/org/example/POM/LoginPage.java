package org.example.POM;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
     WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    private  By login = By.xpath("//a[@title=\"Jobseeker Login\"]");
    private  By loginbutton = By.xpath("//button[@type=\"submit\"]");
    private  By usernameField = By.xpath("//input[@placeholder=\"Enter your active Email ID / Username\"]");
    private  By passwordField = By.xpath("//input[@placeholder=\"Enter your password\"]");

    public void loginTestPositive(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(login).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pwd);
        driver.findElement(loginbutton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
