import com.codeborne.selenide.Configuration;
import enums.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeTest
    public void setup() {
//        Configuration.remote = "http://192.168.100.2:4444/wd/hub";

        Browser browser = Browser.valueOf(System.getProperty("browser", Browser.CHROME.toString()));
        switch (browser) {
            case CHROME: Configuration.browser = CHROME;
            break;
            case EDGE: Configuration.browser = EDGE;
            break;
            case FIREFOX: Configuration.browser = FIREFOX;
            break;
        }

        Configuration.baseUrl = "https://demo.litecart.net/";
        Configuration.pageLoadTimeout = 5000;
        open(Configuration.baseUrl);
    }

    @AfterTest
    public void teardown() {
        closeWebDriver();
    }
}
