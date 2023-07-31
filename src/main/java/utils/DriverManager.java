package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static String testName;

    public static WebDriver getInstance() {
        if (driverThreadLocal.get() == null) {
            if (ConfigReader.getConfiguration().getBoolean("run.locally")) {
                driverThreadLocal.set(new ChromeDriver());
            } else {
                driverThreadLocal.set(configureRemote());
            }
        }
        return driverThreadLocal.get();
    }

    public static void closeDriver() {
        driverThreadLocal.get().close();
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

    private static RemoteWebDriver configureRemote() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("macOS 10.15");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "");
        sauceOptions.put("accessKey", "");
        sauceOptions.put("build", "selenium-build-RJ6LT");
        sauceOptions.put("name", testName);
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new RemoteWebDriver(url, browserOptions);
    }

    public static void markRemoteTest(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        ((JavascriptExecutor) getInstance()).executeScript("sauce:job-result=" + status);
    }
}
