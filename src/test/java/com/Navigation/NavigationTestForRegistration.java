package com.Navigation;

import com.Base.TestBase;
import com.DemoOpenCart.Registration;

public class NavigationTestForRegistration extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        //firefoxLaunch();
        openTestURL("https://demo.opencart.com/");
        NavigateTo();
        Registration.TC_003_Valid();
        NavigateBack();
        NavigateForward();
    }

    public static void NavigateTo(){
        driver.navigate().to("https://demo.opencart.com/index.php?route=account/register");
        System.out.println("Navigate To:"+driver.getTitle());
    }
    public static void NavigateBack(){
        driver.navigate().back();
        System.out.println("Navigate Back To:"+driver.getTitle());
    }
    public static void NavigateForward(){
        driver.navigate().forward();
        System.out.println("Navigate Forward To:"+driver.getTitle());
    }
    public static void NavigateRefresh(){
        driver.navigate().refresh();
    }

}
