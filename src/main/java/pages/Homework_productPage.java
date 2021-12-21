package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homework_productPage extends BasePage {
    Homework_mainPage homework_mainPage = new Homework_mainPage(driver);

    @FindBy(css = ".product-container .product-image-container img")
    WebElement productImg;

    @FindBy(css = ".product-container .product-image-container .quick-view")
    WebElement quickViewBtn;

    @FindBy(id = "thumb_5")
    WebElement firstImg;

    @FindBy(id = "thumb_6")
    WebElement secondImg;

    @FindBy(id = "thumb_7")
    WebElement thirdImg;

    @FindBy(css = ".fancybox-wrap [title='Close']")
    WebElement closeBtn;

    public Homework_productPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Homework_productPage hoverOverProductImg() {
        waitUntil(productImg);
        homework_mainPage.hoverOverAnElement(productImg);
        return this;
    }

    public Homework_productPage clickOnQuickView() {
        waitUntil(quickViewBtn);
        clickOnElement(quickViewBtn);
        return this;
    }

    public Homework_productPage goIntoFrame(){
        driver.switchTo().frame(0);
        return this;
    }

    public Homework_productPage hoverOverFirstLittleImg() {
        waitUntil(firstImg);
        homework_mainPage.hoverOverAnElement(firstImg);
        return this;
    }

    public Homework_productPage hoverOverSecondLittleImg() {
        waitUntil(secondImg);
        homework_mainPage.hoverOverAnElement(secondImg);
        return this;
    }

    public Homework_productPage hoverOverThirdLittleImg() {
        waitUntil(thirdImg);
        homework_mainPage.hoverOverAnElement(thirdImg);
        return this;
    }

    public Homework_productPage goBackToParentFrame(){
        driver.switchTo().defaultContent();
        return this;
    }

    public Homework_productPage closePopUpWindow() {
        clickOnElement(closeBtn);
        return this;
    }
}
