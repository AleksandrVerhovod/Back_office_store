package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.addArguments("--headless"); //фоновый режим
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        threadLocalDriver.set(new ChromeDriver(options));
    }
}