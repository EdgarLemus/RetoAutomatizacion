package co.com.consubanco.certificacion.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDispositivoDriver {

    private static AndroidDriver driver;

    public static AppiumDispositivoDriver conLasCapabilities() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "T45HD_EEA");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.cloudgrey.the_app");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.cloudgrey.the_app.MainActivity");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.UDID, "8563S234762922");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("newCommandTimeout", 180);

            // Configuración adicional
            capabilities.setCapability("appium:timeout", 30000);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error en la URL de Appium Server", e);
        }
        return new AppiumDispositivoDriver();
    }

    public AndroidDriver enElDispositivo() {
        return driver;
    }
}
