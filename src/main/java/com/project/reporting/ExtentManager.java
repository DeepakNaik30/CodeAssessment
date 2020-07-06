package com.project.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentReports getInstance(){
        return extent;
    }

    public static void createInstance(String fileName){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

        htmlReporter.setAppendExisting(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setDocumentTitle("Code Assessment for Emtec Inc");
        htmlReporter.config().setReportName("Emtec Code Assessment");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss a");

        extent = new ExtentReports();
        extent.setSystemInfo("Created By", "Deepak Naik");
        extent.setSystemInfo("Browser", "Chrome");
        extent.attachReporter(htmlReporter);
    }
}
