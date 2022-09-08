package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeatsPage {

    private WebDriver driver;

    public SeatsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By clickAgreementFamilyBnr = By.xpath("//button[@class='seats-modal__cta body-l-lg ry-button--gradient-blue']");
    private By seatForAdult = By.xpath("//button[@id='seat-14F']");
    private By seatForChild = By.xpath("//button[@id='seat-14E']");
    private By btnContinueAfterSelectSeats = By.xpath("//button[@class='ry-button ry-button--gradient-yellow seats-action__button ry-button--flat-blue']");
    private By selectForAllPassengers = By.xpath("//section[@class='booking-content__section']//div[@class='pax-row__controls']//div[1]//bags-table-row-cta[1]//span[1]");
    private By dropDownBags = By.xpath("//icon[@class='icon ng-star-inserted']");
    private By continueBtnAfterSelectBags = By.xpath("//button[text()[normalize-space()='Continue']]");

    private By presentationCancel = By.xpath("//button[@class='enhanced-takeover__product-dismiss-cta ry-button--anchor-blue ry-button--anchor ng-star-inserted']");
    private By continueBtnXpath = By.xpath("//button[@class='app-container__cta ry-button--gradient-yellow ry-button--large ng-star-inserted']");
    private By continueBtnNextPageReservationTransport = By.xpath("//button[@class='app-container__cta ry-button--gradient-yellow ry-button--large']");
    private By goToFlightsTab = By.xpath("//a[normalize-space()='Flights']");
    private By addExtraForChild = By.xpath("//div[@class='passenger__row passenger__row--no-border-top ng-star-inserted']//div[3]");
    private By addBagsForAll = By.xpath("//icon[@class='icon ng-star-inserted']//span[@class='_container icon-16']//*[name()='svg']");
    private By clickAddForAllPassengers = By.xpath("//section[@class='booking-content__section']//div[@class='pax-row__controls']//div[1]//bags-table-row-cta[1]//span[1]");
    private By goToCheckOut = By.xpath("//button[text()=' Go to checkout ']");
    public void selectSeats() throws InterruptedException {
        Thread.sleep(500);

        WebElement clickAgreementFamilyBnrElement = driver.findElement(clickAgreementFamilyBnr);
        clickAgreementFamilyBnrElement.click();

        WebElement seatForAdultElement = driver.findElement(seatForAdult);
        seatForAdultElement.click();

        WebElement seatForChildElement = driver.findElement(seatForChild);
        seatForChildElement.click();

        WebElement btnContinueAfterSelectedSeatsElement = driver.findElement(btnContinueAfterSelectSeats);
        btnContinueAfterSelectedSeatsElement.click();

    }

    public void selectBags() throws InterruptedException {
        WebElement clickDropDownBagsElement = driver.findElement(dropDownBags);
        clickDropDownBagsElement.click();

        WebElement selectForAllPassengersElement = driver.findElement(selectForAllPassengers);
        selectForAllPassengersElement.click();

        WebElement btnContinueElement = driver.findElement(continueBtnAfterSelectBags);
        btnContinueElement.click();

        Thread.sleep(500);

        WebElement clickNoThanksElement = driver.findElement(presentationCancel);
        clickNoThanksElement.click();

        WebElement clickContinueBtnElement = driver.findElement(continueBtnXpath);
        clickContinueBtnElement.click();

        WebElement clickContinueBtnReservationTransportElement = driver.findElement(continueBtnNextPageReservationTransport);
        clickContinueBtnReservationTransportElement.click();

    }

    public void goToCheckOut(){
        WebElement clickGoToCheckout = driver.findElement(goToCheckOut);
        clickGoToCheckout.click();
    }
}
