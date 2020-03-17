package com.automation.tests.day8;

import com.automation.tests.utilities.MethodsContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        MethodsContainer.verifyEquals("cba", "cba");
    }
    @Test (description = "Verify if metod can reverse a string")
    public void test(){
        String expected = "cba";
        String actual = reverseString("abc");
        Assert.assertEquals(expected, actual);
    }
    @Test(description = "Verify if metod can reverse a string")
    public void test2(){
        String expected = "cba";
        String actual = reverseString("abc");
    }

    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}