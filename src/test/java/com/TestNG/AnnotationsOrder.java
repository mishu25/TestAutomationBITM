package com.TestNG;

import org.testng.annotations.*;

public class AnnotationsOrder {
    @BeforeSuite
    public void suiteSetup(){
        System.out.println("Suite Setup Done");
    }
    @BeforeTest
    public void testSetup(){
        System.out.println("Test Setup Done");
    }
    @BeforeClass
    public void classSetup(){
        System.out.println("Class Setup Done");
    }
    @BeforeMethod
    public void methodSetup(){
        System.out.println("Method Setup Done");
    }
    @Test
    public void TC_001(){
        System.out.println("Hello World");
    }
    @Test
    public void TC_002(){
        System.out.println("Hello Bangladesh");
    }
    @AfterMethod
    public void methodExecute(){
        System.out.println("After Method Done");
    }
    @AfterClass
    public void classExecute(){
        System.out.println("After Class Done");
    }
    @AfterTest
    public void testExecute(){
        System.out.println("After Test Done");
    }
    @AfterSuite
    public void suiteExecute(){
        System.out.println("After Suite Done");
    }
}
