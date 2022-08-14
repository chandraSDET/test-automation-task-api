package com.task;

import com.aventstack.extentreports.Status;

import com.task.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener extends RestUtil implements ITestListener {
    @Override
    public void onStart(ITestContext iTestContext) {

    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReport.extentReports.flush();

    }
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        getTest().log(Status.PASS, "Test passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        getTest().log(Status.FAIL, "Test Failed");
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        getTest().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
