package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class Homework_mainPage extends BasePage {
    EventFiringMouse eventFiringMouse;
    WebListener webListener;

    @FindBy(css = "#block_top_menu .sf-menu [title='Women']")
    WebElement womenBtn;

    @FindBy(css = ".submenu-container >li [title='Blouses']")
    WebElement blousesBtn;

    public Homework_mainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Homework_mainPage hoverOverWomenSection() {
        mouseHoverOver(womenBtn);
        return this;
    }

    public void hoverOverAnElement(WebElement element) {
        mouseHoverOver(element);
    }

    private void mouseHoverOver(WebElement element) {
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        waitUntil(element);
    }

    public void goBlousesSection() {
        clickOnElement(blousesBtn);
    }
}
