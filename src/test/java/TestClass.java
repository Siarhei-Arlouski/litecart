import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RubberDucksPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestClass extends TestBase{
    @Test
    public void homePageTest() {
        HomePage.homePageButtonClick();
        $("title").shouldHave(attribute("text", "My Store | Online Store"));
    }

    @Test
    public void rubberDucksPageTest() {
        HomePage.rubberDucksPageButtonClick();
        $("title").shouldHave(attribute("text", "Rubber Ducks | My Store"));
    }

    @Test
    public void deliveryInformationPageTest() {
        HomePage.deliveryInformationPageLinkClick();
        $("title").shouldHave(attribute("text", "Delivery Information | Customer Service | My Store"));
    }

    @Test
    public void termsAndConditionsTest() {
        HomePage.termsAndConditionsLinkClick();
        $("title").shouldHave(attribute("text", "Terms of Purchase | Customer Service | My Store"));
    }

    @Test
    public void sortByNameTest() {
        HomePage.rubberDucksPageButtonClick();
        RubberDucksPage.sortByNameButtonClick();
        $(".name").shouldBe(visible);

        ElementsCollection actualSortListByName = $$(".name");

        actualSortListByName.get(0).shouldHave(text("Yellow Duck"));
        actualSortListByName.get(1).shouldHave(text("Blue Duck"));
        actualSortListByName.get(2).shouldHave(text("Green Duck"));
        actualSortListByName.get(3).shouldHave(text("Purple Duck"));
        actualSortListByName.get(4).shouldHave(text("Red Duck"));
    }

    @Test
    public void sortByPriceTest() {
        HomePage.rubberDucksPageButtonClick();
        $(".name").shouldBe(visible);

        ElementsCollection actualSortListByName = $$(".name");

        actualSortListByName.get(0).shouldHave(text("Yellow Duck"));
        actualSortListByName.get(1).shouldHave(text("Green Duck"));
        actualSortListByName.get(2).shouldHave(text("Red Duck"));
        actualSortListByName.get(3).shouldHave(text("Blue Duck"));
        actualSortListByName.get(4).shouldHave(text("Purple Duck"));
    }

    @Test
    public void greenDuckLabelTest() {
        HomePage.rubberDucksPageButtonClick();
        $(RubberDucksPage.greenDuckLabelText()).shouldHave(text("new"));
    }

    @Test
    public void yellowDuckLabelTest() {
        HomePage.rubberDucksPageButtonClick();
        $(RubberDucksPage.yellowDuckLabelText()).shouldHave(text("sale"));
    }

    @Test
    public void openLiteCartSiteTest() {
        HomePage.liteCartLinkClick();

        switchTo().window(1);
        $("title").shouldHave(attribute("text", "LiteCart - Free shopping cart platform"));
        closeWindow();

        switchTo().window(0);
        $("title").shouldHave(attribute("text", "My Store | Online Store"));
    }
}
