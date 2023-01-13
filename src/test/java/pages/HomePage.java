package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static final By homePageButton = By.xpath("//*[@class='fa fa-home hidden-xs hidden-sm']");
    private static final By categoriesButton = By.xpath("//*[@class='nav-link'][text()='Categories']");
    private static final By rubberDucksPageButton = By.xpath("//*[@class='nav-link'][text()='Rubber Ducks']");
    private static final By deliveryInformationPageLink = By.xpath("//*[text()='Delivery Information']");
    private static final By termsAndConditionsLink = By.xpath("//*[text()='Terms of Purchase']");
    private static final By liteCartLink = By.xpath("//*[@title='Free e-commerce platform']");

    public static void homePageButtonClick() {
        $(homePageButton).click();
    }

    public static void rubberDucksPageButtonClick() {
        $(categoriesButton).click();
        $(rubberDucksPageButton).shouldBe(Condition.enabled).click();
    }

    public static void deliveryInformationPageLinkClick() {
        $(deliveryInformationPageLink).click();
    }

    public static void termsAndConditionsLinkClick() {
        $(termsAndConditionsLink).click();
    }

    public static void liteCartLinkClick() {
        $(liteCartLink).click();
    }
}
