package com.Navigation;

import com.Base.TestBase;

public class NavigationTest extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestURL("https://demo.opencart.com/");
        navigateTo();
        navigateBack();
        navigateForward();
    }
    public static void navigateTo(){
        driver.navigate().to("https://google.com");
        System.out.println("Navigate To:"+driver.getTitle());


    }
    public static void navigateBack(){
        driver.navigate().back();
        System.out.println("Navigate Back To:"+driver.getTitle());

    }
    public static void navigateForward(){
        driver.navigate().forward();
        System.out.println("Navigate Forward To:"+driver.getTitle());

    }
    public static void navigateRefresh(){
        driver.navigate().refresh();

    }
}
