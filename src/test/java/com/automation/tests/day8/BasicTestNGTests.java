package com.automation.tests.day8;

import com.automation.tests.utilities.MethodsContainer;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeTest
    public void beforeTest(){
        //something that should be done only once in the class before all tests
        System.out.println("BEFORE Test");
    }

    @AfterTest
    public void afterTest(){
        //something that should be done only once in the class after all tests
        System.out.println("AFTER Test");
    }
    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        //something that should be done only once in the class after all tests
        System.out.println("AFTER CLASS");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }
    @Test
    public void test(){
        System.out.println("Test 1");
        String expected = "cba";
        String actual = "cba";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1 = 5;
        int num2 = 6;
        Assert.assertTrue(num1<num2);
    }
}
