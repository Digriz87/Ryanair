package pages;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import static org.openqa.selenium.Keys.TAB;

public class MainPage {

    private WebDriver driver;
    WebElement fromAirport;
    WebElement toAirportElement;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    private By btnDone = By.xpath("//button[@aria-label='Done']");
    private By selectChildren = By.xpath("//ry-counter[@data-ref='passengers-picker__children']//div[@class='counter__button-wrapper--enabled']");

    private By toAirport = By.xpath("//input[@id='input-button__destination']");
    private By fromAirportPath = By.xpath("//input[@id='input-button__departure']");
    private By freeDayForFly = By.xpath("//div[@class='calendar-body__cell calendar-body__cell--weekend']");
    private By selectDestinationAirport = By.xpath("//span[@data-id='ALC']");
    private By btnSearch = By.xpath("//button[@aria-label='Search']");
    private By oneWay = By.xpath("//label[normalize-space()='One way']");
    private By privacyCheck = By.xpath("//p[normalize-space()='We value your privacy']");
    private By btnAgreePrivacy = By.xpath("//button[@class='cookie-popup-with-overlay__button']");

    public void searchDestinations() throws InterruptedException {
        WebElement valuePrivacy = driver.findElement(privacyCheck);
        WebElement btnAgrPrivacy = driver.findElement(btnAgreePrivacy);
        WebElement oneWayElement = driver.findElement(oneWay);
        boolean checkPrivacyIsVisible = valuePrivacy.isDisplayed();
        if (!checkPrivacyIsVisible) {
            oneWayElement.click();
        } else {
            btnAgrPrivacy.click();
            oneWayElement.click();
        }


        fromAirport = driver.findElement(fromAirportPath);
        fromAirport.click();
        fromAirport.clear();
        fromAirport.sendKeys("Lodz");
        fromAirport.sendKeys(TAB);

        Thread.sleep(500);

        toAirportElement = driver.findElement(toAirport);
        WebElement selectAirportDestinations = driver.findElement(selectDestinationAirport);
        toAirportElement.sendKeys("Alicante");
        selectAirportDestinations.click();
        toAirportElement.sendKeys(TAB);

        Thread.sleep(500);

        WebElement freeFlyDay = driver.findElement(freeDayForFly);
        freeFlyDay.click();

        WebElement childrenIncrement = driver.findElement(selectChildren);
        childrenIncrement.click();

        WebElement btnDoneClick = driver.findElement(btnDone);
        btnDoneClick.click();

        WebElement btnSearchClick = driver.findElement(btnSearch);
        btnSearchClick.click();

        Thread.sleep(1000);

    }
}