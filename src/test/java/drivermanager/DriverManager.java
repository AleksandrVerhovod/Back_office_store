package drivermanager;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

//абстрактный класс с абстрактным методом createDriver, который имплементируется у всех наследников,
// опишем все общие методы, чтобы работать с драйвером (размер, таймауты)
public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public abstract void createDriver();

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public void startMaximize() {
        threadLocalDriver.get().manage().window().maximize();
    }

    public void setTimeout() {
        threadLocalDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        threadLocalDriver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        getDriver().quit();
    }
}