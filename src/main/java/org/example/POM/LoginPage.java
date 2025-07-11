package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }
    private By login = By.xpath("//a[@title=\"Jobseeker Login\"]");
    private By loginbutton = By.xpath("//button[@type=\"submit\"]");
    private By usernameField = By.xpath("//input[@placeholder=\"Enter your active Email ID / Username\"]");
    private By passwordField = By.xpath("//input[@placeholder=\"Enter your password\"]");

    public String loginTestPositive(String user, String pwd){

    }
}
