import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RubberDucksPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.fail;

public class TestClass extends TestBase{

    @Test
    @Feature("SP-01")
    @Description("Home page title test")
    public void homePageTest() {
        HomePage.homePageButtonClick();
        $("title").shouldHave(attribute("text", "My Store | Online Store"));
    }

    @Test
    @Feature("SP-02")
    @Description("Rubber ducks page title test")
    public void rubberDucksPageTest() {
        HomePage.rubberDucksPageButtonClick();
        $("title").shouldHave(attribute("text", "Rubber Ducks | My Store"));
    }

    @Test
    @Feature("SP-03")
    @Description("Delivery information page title test")
    public void deliveryInformationPageTest() {
        HomePage.deliveryInformationPageLinkClick();
        $("title").shouldHave(attribute("text", "Delivery Information | Customer Service | My Store"));
    }

    @Test
    @Feature("SP-04")
    @Description("Terms and conditions page title test")
    public void termsAndConditionsTest() {
        HomePage.termsAndConditionsLinkClick();
        $("title").shouldHave(attribute("text", "Terms of Purchase | Customer Service | My Store"));
    }

    @Test
    @Feature("SP-05")
    @Description("Sort ducks by name test")
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
    @Feature("SP-06")
    @Description("Sort ducks by price test")
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
    @Feature("SP-07")
    @Description("Green duck new label test")
    public void greenDuckLabelTest() {
        HomePage.rubberDucksPageButtonClick();
        $(RubberDucksPage.greenDuckLabelText()).shouldHave(text("new"));
    }

    @Test
    @Feature("SP-08")
    @Description("Yellow duck sale label test")
    public void yellowDuckLabelTest() {
        HomePage.rubberDucksPageButtonClick();
        $(RubberDucksPage.yellowDuckLabelText()).shouldHave(text("sale"));
    }

    @Test
    @Feature("SP-09")
    @Description("LiteCart page title test")
    public void openLiteCartSiteTest() {
        HomePage.liteCartLinkClick();

        switchTo().window(1);
        $("title").shouldHave(attribute("text", "LiteCart - Free shopping cart platform"));
        closeWindow();

        switchTo().window(0);
        $("title").shouldHave(attribute("text", "My Store | Online Store"));
    }

    @Test
    @Description("Test failure for Allure report")
    public void testFailure() {
        fail("Test failure for Allure report");
    }
}
