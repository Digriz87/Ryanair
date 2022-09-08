package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.concurrent.TimeUnit;


public class BookingSteps  {
    private static WebDriver driver;
    MainPage mainPage = new MainPage(driver);
    FlightsPage flightsPage = new FlightsPage(driver);
    SeatsPage seatsPage = new SeatsPage(driver);
    SignInPage signUpPage = new SignInPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);

    @Before
    public static void startup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Given("I make a booking")
    public void iMakeABooking() throws InterruptedException {
        driver.get("https://www.ryanair.com/ie/en/");
        //signUpPage.signIn(); // Need to take Activation Code from email for finish CheckOut Page
        mainPage.searchDestinations();
        flightsPage.selectFlyFromResultsOfSearch();
        seatsPage.selectSeats();
        seatsPage.selectBags();
        seatsPage.goToCheckOut();
    }

    @When("I pay for booking with card details")
    public void iPayForBookingWithCardDetails() {
        checkOutPage.fillInfoForCreatePayment();
    }

    @Then("I should get payment message")
    public void iShouldGetPaymentMessage() {
        checkOutPage.checkResultOfPayment();
    }

    @After
    public void exit(){
        driver.quit();
    }
}

