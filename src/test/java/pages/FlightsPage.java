package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.openqa.selenium.Keys.TAB;

public class FlightsPage {

    private WebDriver driver;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By selectPackage = By.xpath("//div[@class='fare-card fare-card--primary']");
    private By btnSubmitFly = By.xpath("//button[text()=' Select ']");
     private By continueBtnRegular = By.xpath("//button[text()=' Continue with Value fare ']");
    private By continueWithoutLogin = By.xpath("//span[@class='login-touchpoint__login-later h3']");
    private By firstNameFieldFirstPassenger = By.xpath("//input[@id='form.passengers.ADT-0.name']");
    private By surnameNameFieldFirstPassenger = By.xpath("//input[@id='form.passengers.ADT-0.surname']");
    private By firstNameFieldChild = By.xpath("//input[@id='form.passengers.CHD-0.name']");
    private By surnameNameFieldChild = By.xpath("//input[@id='form.passengers.CHD-0.surname']");
    private By bannerClose = By.xpath("//icon[@class='toast__close toast__close--SOFT']");

    private By btnContinue = By.xpath("//button[text()=' Continue ']");

    public void selectFlyFromResultsOfSearch() throws InterruptedException {

        Thread.sleep(500);
        WebElement btnSelectFly = driver.findElement(btnSubmitFly);
        btnSelectFly.sendKeys(TAB);
        btnSelectFly.click();

        Thread.sleep(100);

        WebElement selectPackageElement = driver.findElement(selectPackage);
        selectPackageElement.click();

        Thread.sleep(500);

        WebElement btnContinueRegular = driver.findElement(continueBtnRegular);
        btnContinueRegular.click();

        Thread.sleep(500);

        WebElement continueWithoutLoginElement = driver.findElement(continueWithoutLogin);
        continueWithoutLoginElement.click();

        WebElement bannerElement = driver.findElement(bannerClose);
        boolean checkBannerIsVisible = bannerElement.isDisplayed();
        if (checkBannerIsVisible) {
            bannerElement.click();
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement xPathDropDown = driver.findElement(By.xpath("(//button[contains(@class,'dropdown__toggle b2')])"));
        xPathDropDown.click();

        WebElement selectMrsElement = driver.findElement(By.xpath("//*[contains(text(), \"Mrs\")]"));
        selectMrsElement.click();

        ArrayList arrayList;
        arrayList = generatorNamesAndSurnames();

        WebElement firstNameFieldElementPassengerOne = driver.findElement(firstNameFieldFirstPassenger);
        firstNameFieldElementPassengerOne.sendKeys((CharSequence) arrayList.get(1));

        WebElement surnameNameFieldElementPassengerOne = driver.findElement(surnameNameFieldFirstPassenger);
        surnameNameFieldElementPassengerOne.sendKeys((CharSequence) arrayList.get(2));

        WebElement firstNameFieldElementChild = driver.findElement(firstNameFieldChild);
        firstNameFieldElementChild.sendKeys((CharSequence) arrayList.get(3));

        WebElement surnameNameFieldElementChild = driver.findElement(surnameNameFieldChild);
        surnameNameFieldElementChild.sendKeys((CharSequence) arrayList.get(4));

        WebElement btnContinueElement = driver.findElement(btnContinue);
        btnContinueElement.click();
    }

    public ArrayList generatorNamesAndSurnames(){
        ArrayList tempList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String generatedString = RandomStringUtils.randomAlphabetic(10);
            tempList.add(generatedString);
        }
        return tempList;
    }
}
