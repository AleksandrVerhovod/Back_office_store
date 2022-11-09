package drivermanager;


import constants.Credentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 12");
        browserOptions.setCapability("browserVersion", "15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1.0");
        sauceOptions.put("name", "Qase.io");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {

            RemoteWebDriver RemoteWebDriver = new RemoteWebDriver(new URL(Credentials.REMOTE), browserOptions);
            threadLocalDriver.set(RemoteWebDriver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
