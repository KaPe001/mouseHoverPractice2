package tests;

import org.junit.jupiter.api.Test;
import pages.Homework_mainPage;
import pages.Homework_productPage;
import testBase.TestBaseHomework;

public class HomeworkTest extends TestBaseHomework {

    @Test
    public void goToWomenSectionAndSeeTheBlouse(){
        new Homework_mainPage(webDriver)
                .hoverOverWomenSection()
                .goBlousesSection();

        new Homework_productPage(webDriver)
                .hoverOverProductImg()
                .clickOnQuickView()
                .goIntoFrame()
                .hoverOverFirstLittleImg()
                .hoverOverSecondLittleImg()
                .hoverOverThirdLittleImg()
                .goBackToParentFrame()
                .closePopUpWindow();
    }
}
