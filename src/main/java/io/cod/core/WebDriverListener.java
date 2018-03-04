package io.cod.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WebDriverListener implements IInvokedMethodListener {


    //    ThreadLocal исключает ошибку при многопоточном тестировании
    //private static WebDriver driver;
    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
//            driver = new ChromeDriver();
            //final FirefoxDriver chromeDriver = new FirefoxDriver();
            final ChromeDriver chromeDriver = new ChromeDriver();

            // time out
            chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            DRIVER_CONTAINER.set(new ChromeDriver());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            Optional.ofNullable(getDriver()).ifPresent(WebDriver::quit);
        //    DRIVER_CONTAINER.get().quit();
//            driver.quit();
            DRIVER_CONTAINER.remove();
        }
    }


    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }


}
