package com.DemoOpenCart;

import com.Base.TestBase;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
Steps:
-> Go to Registration page.
-> Fill up all Field.
-> Agree to the Privacy Policy and then
-> Register.
 */

public class Registration extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        TC_003_Valid();
        //TC_004_InValid();
    }
    public static void TC_003_Valid(){
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        WebElement FirstName=driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("motahara");
       // getElementByCSSandType("input-firstname","motahara");

        WebElement LastName=driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("mishu");

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("mishu001@gmail.com");

        WebElement Telephone=driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("01234567891");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");

        WebElement PasswordConfirm=driver.findElement(By.id("input-confirm"));
        PasswordConfirm.sendKeys("123456");

        WebElement PrivacyPolicy=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        PrivacyPolicy.click();

        WebElement ContinueBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ContinueBtn.click();

        //logic develop
        //logic pass
        String Exp_urlAd="https://demo.opencart.com/index.php?route=account/success";
        String Act_urlAd=driver.getCurrentUrl();
        String Exp_warning="Warning: E-Mail Address is already registered!";
        String Act_warning=driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible")).getText();
        if(Exp_urlAd.equals(Act_urlAd)){
            System.out.println("Test pass for valid data");
        }
        else if(Exp_warning.equals(Act_warning)){
            System.out.println("Email address is already registered, please choose another one and try again.");
        }
        else{
            System.out.println("Test failed for valid data, Bug FOUND!!!");
        }
    }

   /* public static void TC_004_InValid(){
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement First_name = driver.findElement(By.id("input-firstname"));
        First_name.sendKeys("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        WebElement Last_name = driver.findElement(By.id("input-lastname"));
        Last_name.sendKeys("");
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("");
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("11");
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("12");
        WebElement Confirm_password = driver.findElement(By.id("input-confirm"));
        Confirm_password.sendKeys("12");
        WebElement ClickOnAgree = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        ClickOnAgree.click();
        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ClickContinue.click();
        String Exp_FirstName_Validation_Message="First Name must be between 1 and 32 characters!";
        String Act_FirstName_Validation_Message=driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();
        if(Exp_FirstName_Validation_Message.equals(Act_FirstName_Validation_Message)){
            System.out.println("First name validation pass");
        }
        else{
            System.out.println("Validation failed for 1st name,yahoooo Bug found.");
        }

        String Exp_LastNameValidationMessage="Last Name must be between 1 and 32 characters!";
        String Act_LastNameValidationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(4) > div > div")).getText();
        if(Exp_LastNameValidationMessage.equals(Act_LastNameValidationMessage)){
            System.out.println("Last name validation pass");
        }
        else{
            System.out.println("Validation failed for last name,yahoooo Bug found.");
        }

        //Email validation
        String Exp_EmailValidationMessage = "E-Mail Address does not appear to be valid!";
        String Act_EmailValidationMessage = driver.findElement(By.cssSelector("#account > div:nth-child(5) > div > div")).getText();
        if(Exp_EmailValidationMessage.equals(Act_EmailValidationMessage)){
            System.out.println("Email validation passed");
        }
        else {
            System.out.println("Yahoo, Bug detected in Email field");
        }

        String Exp_TelephoneValidationMessage="Telephone must be between 3 and 32 characters!";
        String Act_TelephoneValidationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(6) > div > div")).getText();
        if(Exp_TelephoneValidationMessage.equals(Act_TelephoneValidationMessage)){
            System.out.println("Telephone validation pass");
        }
        else{
            System.out.println("Validation failed for Telephone,yahoooo Bug found.");
        }
        //validation check for password
        String Exp_PasswordValidationMessage="Password must be between 4 and 20 characters!";
        String Act_PasswordValidationMessage=driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")).getText();
        if(Exp_PasswordValidationMessage.equals(Act_PasswordValidationMessage)){
            System.out.println("Password validation pass");
        }
        else{
            System.out.println("Validation failed for Password,yahoooo Bug found.");
        }

    }*/
}
