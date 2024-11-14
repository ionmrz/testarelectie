package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.FormaPage;

public class FormeTest {

    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\L213_PC07\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void FormTest()
    {
        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage page = new FormaPage(driver);
        page.setFirstNameEl("Ion");
        page.setLastNameEl("Mirza");
        page.setEmailEl("ionxmrzw2112@gmail.com");
        page.setGenderEl("Male");
        page.setMobileEl("0692663377");
        page.setDateOfBirthEl("15 Jun 2005");
        page.selectSubjects();
        page.setHobbiesEl("hobbies-checkbox-3");
        page.setHobbiesEl("hobbies-checkbox-1");
        page.setUploadPictureEl("C:\\Users\\L213_PC07\\Desktop\\test (1)\\student.jpg");
        page.setCurrentAddressEl("Rep. Moldova, Chisinau, str. Ion Creanga 1/2");
        page.setStateEl("NCR");
        page.setCityEl("Noida");
    }


    @AfterClass
    public void close(){
            driver.quit();
    }
}
