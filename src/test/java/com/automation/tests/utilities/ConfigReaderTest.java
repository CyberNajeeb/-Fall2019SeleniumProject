package com.automation.tests.utilities;

import org.testng.annotations.Test;

public class ConfigReaderTest {

   @Test
    public void readProperties(){
       String browser = ConfigReader.getProperty("browser");
       System.out.println("browser: "+browser);
       String url = ConfigReader.getProperty("qa1");
       System.out.println("url: "+url);
       String username = ConfigReader.getProperty("store_manager");
       System.out.println("username: "+username);
       String password = ConfigReader.getProperty("password");
       System.out.println("password: "+password);
   }
}