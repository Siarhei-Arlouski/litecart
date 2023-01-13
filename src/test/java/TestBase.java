import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeTest
    public void setup() {
        Configuration.baseUrl = "https://demo.litecart.net/";
        Configuration.browser = CHROME;
        Configuration.pageLoadTimeout = 5000;
        open(Configuration.baseUrl);
    }

    @AfterTest
    public void teardown() {
        closeWebDriver();
    }
}
