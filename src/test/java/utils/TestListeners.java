package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;


public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Passed");
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(driver);
        allureService.getSystemName();
        allureService.getBrowserName();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Fail");
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(driver);
        allureService.getSystemName();
        allureService.getBrowserName();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test Fail with success percentage");
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(driver);
        allureService.getSystemName();
        allureService.getBrowserName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

}