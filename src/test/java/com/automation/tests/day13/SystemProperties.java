package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
        String pathToDownloads = System.getProperty("user.home")+"/Downloads";
        System.out.println("pathToDownloads = " + pathToDownloads);
        System.out.println(System.getProperty("os.arch"));

    }
}
