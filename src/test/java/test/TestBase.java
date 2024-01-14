package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attach;
import java.util.Map;



public class TestBase {
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void setUp() {

        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browser = webDriverConfig.getBrowser();
//        Configuration.pageLoadStrategy = "eager";

        if (webDriverConfig.isRemote()!= null) {
            Configuration.remote = webDriverConfig.remoteBrowserUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}