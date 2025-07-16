package org.example.POM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

        WebElement upload = presenceOfElement(updateResume);
        upload.click();
        visibiltyOfElementAndClick(updateResume);
        String working_dir = System.getProperty("user.dir");
        String resumePath = working_dir + "/src/main/resources/Navaneeth H.K.pdf";
        upload.sendKeys(resumePath);

        try {
            visibiltyOfElement(updateResume);
            visibiltyOfElementAndClick(updateResume);
            WebElement fileInput =presenceOfElement("//input[@type='file']");

            String filePath = "C:\\Users\\Navaneeth H K\\Desktop\\Resumes of Navneeth\\NAVANEETH H K.pdf";
            File file = new File(filePath);

            if (!file.exists()) {
                System.err.println("File not found: " + filePath);
                return;
            }

            fileInput.sendKeys(file.getAbsolutePath());

            WebElement openButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Open')]"))
            );

            openButton.click();

            // Wait for upload completion
            Thread.sleep(3000);

            System.out.println("Resume uploaded successfully!");

        } catch (Exception e) {
            System.err.println("Error during resume upload: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public WebElement resumeUploaded(){
        visibiltyOfElement(successMessage);
        return getElement(successMessage);
    }

}
