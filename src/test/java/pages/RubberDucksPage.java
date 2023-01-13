package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RubberDucksPage {
    private static final By sortByDropdownButton = By.xpath("//*[@class='form-control'][contains(text(),'Sort By')]");
    private static final By sortByNameButton = By.xpath("//*[@class='title'][text()='Name']");
    private static final By greenDuckLabelText = By.xpath("//*[@class='sticker new'][text()='New']");
    private static final By yellowDuckLabelText = By.xpath("//*[@class='sticker sale'][text()='Sale']");

    public static void sortByNameButtonClick() {
        $(sortByDropdownButton).click();
        $(sortByNameButton).shouldBe(Condition.enabled).click();
    }

    public static By greenDuckLabelText() {
        return greenDuckLabelText;
    }

    public static By yellowDuckLabelText() {
        return yellowDuckLabelText;
    }
}
