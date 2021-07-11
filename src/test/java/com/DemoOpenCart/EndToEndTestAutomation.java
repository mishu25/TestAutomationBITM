package com.DemoOpenCart;

import com.Base.TestBase;

public class EndToEndTestAutomation extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openTestURL("https://demo.opencart.com/");
        NavigateTo();
        Registration.TC_003_Valid();
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
