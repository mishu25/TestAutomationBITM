package com.DataDriven;

import com.utils.Log;
import com.utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DD_RegistrationTest {
    WebDriver driver;
    String RegistrationURL = "https://demo.opencart.com/index.php?route=account/register";

    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("Chrome Launch successfully.");
        }


    }

    @AfterClass
    public void tearDown() {
        driver.close();
        Log.info("Chrome close successfully.");
    }

    @Test
    public void TC_003_Valid() {
        driver.get(RegistrationURL);
        Log.info("Registration page open successfully.");

        //Excel
        Xls_Reader reader = new Xls_Reader("./src/test/resources/RegistrationData.xlsx");
        String sheetName = "Sheet1";
        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String firstname = reader.getCellData(sheetName, "Firstname", rowNum);
            String lastname = reader.getCellData(sheetName, "Lastname", rowNum);
            String email = reader.getCellData(sheetName, "Email", rowNum);
            String telephone = reader.getCellData(sheetName, "Telephone", rowNum);
            String password = reader.getCellData(sheetName, "Password", rowNum);
            String confirmPass = reader.getCellData(sheetName, "Confirmpassword", rowNum);

            WebElement FirstName = driver.findElement(By.id("input-firstname"));
            FirstName.clear();
            FirstName.sendKeys(firstname);
            Log.info("Type Firstname:" + firstname);

            WebElement LastName = driver.findElement(By.id("input-lastname"));
            LastName.clear();
            LastName.sendKeys(lastname);
            Log.info("Type Lastname:" + lastname);

            WebElement Email = driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);
            Log.info("Type Email:" + email);

            WebElement Telephone = driver.findElement(By.id("input-telephone"));
            Telephone.clear();
            Telephone.sendKeys(telephone);
            Log.info("Type Telephone:" + telephone);


            WebElement Password = driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(password);
            Log.info("Type password:" + password);


            WebElement ConfirmPass = driver.findElement(By.id("input-confirm"));
            ConfirmPass.clear();
            ConfirmPass.sendKeys(confirmPass);
            Log.info("Type confirm password:" + confirmPass );

            WebElement PolicyButton=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
            PolicyButton.click();
            Log.info("Check On Privacy Policy.");

            WebElement Continue=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
            Continue.click();
            Log.info("Click on Continue Button.");

            //Logic Develop
            String Exp_url =  "https://demo.opencart.com/index.php?route=account/register";
            String Act_url = driver.getCurrentUrl();

            if (Exp_url.equals(Act_url)) {
                //Excel write
                reader.setCellData(sheetName,"Result",rowNum,"Login. Test Passed.");
            } else {
                //Excel write
                reader.setCellData(sheetName,"Result",rowNum,"Not Login! Test Failed.");
            }

            //Assertion
            //Assert.assertEquals(Act_url, Exp_url);

        }
    }
}
