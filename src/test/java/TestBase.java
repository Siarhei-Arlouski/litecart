import com.codeborne.selenide.Configuration;
import enums.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeTest
    public void setup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", Browser.CHROME.toString()));
        switch (browser) {
            case CHROME -> Configuration.browser = CHROME;
            case FIREFOX -> Configuration.browser = FIREFOX;
            case EDGE -> Configuration.browser = EDGE;
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
