package com.project.reporting;

import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;

public class ExtentReporting {
    private static ExtentTest test;

    public static void createTest(String name, Method method, String[] groups){
        test = ExtentManager.getInstance().createTest(name);

        //Get group info for each test case and display them on Categories tab of extent report
        if(groups.length > 1){
            for(String testGroup : groups){
                test.assignCategory(testGroup);
            }
        }
        test.info("<b>Test Method Name: </b> " + method.getName());
    }

    public static void endTest(){
        ExtentManager.getInstance().flush();
    }
}
