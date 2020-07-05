package com.project.utility;

import com.project.reporting.ExtentManager;
import com.project.reporting.ExtentReporting;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setup(ITestContext ctx){
        initializeExtentReport();
        //setupSSL();
    }

    @BeforeMethod(alwaysRun = true)
    public void baseTest(Method method){
        String testName = method.getAnnotation(Test.class).testName();

        //ExtentReporting.createTest(testName);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        ExtentReporting.endTest();
    }

    private void initializeExtentReport(){
        if(ExtentManager.getInstance() == null){
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yy");
            String formattedDate = dateFormat.format(date);
            ExtentManager.createInstance("results/" + "Code_Assessment_" + formattedDate);
        }
    }

    //Set SSL Path.
//    private void setupSSL(){
//        System.setProperty("javax.net.ssl.trustStore", "xyz");
//        System.setProperty("javax.net.ssl.trustStorePassword", "Password");
//        System.setProperty("javax.net.ssl.keyStore", "keyStore");
//        System.setProperty("javax.net.ssl.keyStorePassword", "keyPassword");
//        System.setProperty("javax.net.ssl.keyStoreType", "xyz");
//        //Disabling host name check
//        HostnameVerifier allHostsAreValid = (arg0, arg1) -> true;
//        //Installing all trusting host verifier
//        HttpURLConnection.setDefaultHostnameVerifier(allHostsAreValid);
//    }

}
