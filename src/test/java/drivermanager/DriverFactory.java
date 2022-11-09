package drivermanager;

public class DriverFactory {
    public DriverManager getManager(DriverType driverType) {

        DriverManager driverThreadLocalManager;

        switch (driverType) {
            case CHROME:
                driverThreadLocalManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverThreadLocalManager = new FirefoxDriverManager();
                break;
            case REMOTE:
                driverThreadLocalManager = new RemoteDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type " + driverType);
        }
        return driverThreadLocalManager;
    }
}
