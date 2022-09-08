package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;

public class SignInPage {
    private WebDriver driver;

    String email = "eugenebondthe@tutanota.com";
    String password = "Hello123!!!";
    WebElement continueGoogleBtn;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    private By clickSignBtn = By.xpath("//button[normalize-space()='Log in']");
    private By fieldForEmail = By.xpath("//input[@placeholder='email@email.com']");
    private By fieldForPassword = By.xpath("//input[@placeholder='Password']");
    private By signInLink  = By.xpath("//span[text()='Log In']");
    private By oneWay = By.xpath("//label[normalize-space()='One way']");
    private By privacyCheck = By.xpath("//p[normalize-space()='We value your privacy']");
    private By btnAgreePrivacy = By.xpath("//button[@class='cookie-popup-with-overlay__button']");
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By btnGoToEmail = By.xpath("//div[@class='button-content flex items-center login plr-button justify-center']");
    private By titleOfEmail = By.xpath("//div[@class='text-ellipsis flex-grow'][normalize-space()='Activation Code']");

    public void signIn() throws InterruptedException {
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


        WebElement signInLinkElement = driver.findElement(signInLink);
        signInLinkElement.click();

        WebElement fieldForEmailElement = driver.findElement(fieldForEmail);
        fieldForEmailElement.click();
        fieldForEmailElement.sendKeys(email);

        WebElement fieldForPasswordElement = driver.findElement(fieldForPassword);
        fieldForEmailElement.click();
        fieldForPasswordElement.sendKeys(password);

        WebElement clickBtnSignIn = driver.findElement(clickSignBtn);
        clickBtnSignIn.click();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://mail.tutanota.com/login?noAutoLogin=true");

        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.click();
        emailFieldElement.sendKeys(email);

        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.click();
        passwordFieldElement.sendKeys(password);

        WebElement btnEnterToTutanotta = driver.findElement(btnGoToEmail);
        btnEnterToTutanotta.click();

        WebElement titleOfEmailWithActivationCode = driver.findElement(titleOfEmail);
        titleOfEmailWithActivationCode.click();

    }
}
