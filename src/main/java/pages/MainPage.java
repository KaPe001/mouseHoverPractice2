package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends BasePage{
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    private EventFiringMouse eventFiringMouse;
    private WebListener webListener;

    @FindBy(css = "[id='header'] [id='_desktop_user_info'] .hidden-sm-down")
    WebElement logInBtn;

    @FindBy(css = ".user-info span")
    WebElement userNameDisplayed;

    @FindBy(css = ".user-info .logout")
    WebElement logOutBtn;

    @FindBy(css = "#category-3 > a")
    WebElement clothes;

    @FindBy(css = "#category-6 > a")
    WebElement accessories;

    @FindBy(css = "#category-9 > a")
    WebElement art;

    public MainPage mouseHoverClothes(){
        logger.info("Mouse hover on clothes link");
        mouseHover(clothes);
        return this;
    }

    public MainPage mouseHoverAccessories(){
        logger.info("Mouse hover on accessories link");
        mouseHover(accessories);
        return this;
    }

    public MainPage mouseHoverArt(){
        logger.info("Mouse hover on art link");
        mouseHover(art);
        return this;
    }

    private void mouseHover(WebElement webElement) {
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        clickOnElement(logInBtn);
    }

    public String verifyLoggedUserInfo() {
        System.out.println(userNameDisplayed.getText());
        return userNameDisplayed.getText();
    }

    public void logUserOut() {
        clickOnElementToSignUserOut(logOutBtn);
        if (userNameDisplayed.getText().equals("Sign in")) {
            System.out.println("User signed out properly");
        }
    }
}
