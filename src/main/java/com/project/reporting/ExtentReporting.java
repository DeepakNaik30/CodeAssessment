package com.project.reporting;

import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;
import java.util.List;

public class ExtentReporting {
    private static ExtentTest test;

    public static void createTest(String name, Method method, List<String> categoryList){
        test = ExtentManager.getInstance().createTest(name);
        if(!categoryList.isEmpty()){
            for(String category : categoryList){
                test.assignCategory(category);
            }
        }
        test.info("<b>Test Method Name: </b> " + method.getName());
    }

    public static void endTest(){
        ExtentManager.getInstance().flush();
    }
}
