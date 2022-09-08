package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By fieldForTelNumber = By.xpath("//input[@name='phone-number']");
    private By selectNotInsurance = By.xpath("//label[@for='insurance-opt-out']");
    private By fieldForNumberCard = By.xpath("//div[@class='desktop-container ng-star-inserted']");
    private By fieldExpirationDate = By.xpath("//input[@name='cc-exp']");
    private By fieldOfCvv = By.xpath("//input[@placeholder='CVV']");
    private By fieldOfAddressOne = By.xpath("//input[@name='address-line1']");
    private By fieldOfCity = By.xpath("//input[@name='city']");
    private By fieldOfCountry = By.xpath("//input[@name='country']");
    private By fieldOfPostalCode = By.xpath("//input[@name='postcode']");
    private By fieldCardHolderName = By.xpath("//input[@name='ccname']");
    private By termsAndConditions = By.xpath("//label[@for='termsAndConditions']//div[@class='_background']");
    private By selectCurrency = By.xpath("///*[contains(text(), \"PLN\")]");
    private By answerAboutIncorrectData = By.xpath("//div[@class='b2 ng-star-inserted']");


    public void fillInfoForCreatePayment(){
        WebElement fieldOfNumber = driver.findElement(fieldForTelNumber);
        fieldOfNumber.click();
        fieldOfNumber.sendKeys("2222222222");

        WebElement selectNotInsuranceElement = driver.findElement(selectNotInsurance);
        selectNotInsuranceElement.click();

        WebElement fieldForNumberCardElement = driver.findElement(fieldForNumberCard);
        fieldForNumberCardElement.click();
        fieldForNumberCardElement.sendKeys("5555 5555 5555 5557");

        WebElement fieldExpirationDateElement = driver.findElement(fieldExpirationDate);
        fieldExpirationDateElement.click();
        fieldExpirationDateElement.sendKeys("10/25");

        WebElement fieldOfCvvElement = driver.findElement(fieldOfCvv);
        fieldOfCvvElement.click();
        fieldOfCvvElement.sendKeys("265");

        WebElement fieldOfAddressOneElement = driver.findElement(fieldOfAddressOne);
        fieldOfAddressOneElement.click();
        fieldOfAddressOneElement.sendKeys("testtesttest");

        WebElement fieldOfCityElement = driver.findElement(fieldOfCity);
        fieldOfCityElement.click();
        fieldOfCityElement.sendKeys("citycity");

        WebElement fieldOfCountryElement = driver.findElement(fieldOfCountry);
        fieldOfCountryElement.click();
        fieldOfCountryElement.sendKeys("London");
        fieldOfCountryElement.submit();

        WebElement fieldOfPostalCodeElement = driver.findElement(fieldOfPostalCode);
        fieldOfPostalCodeElement.click();
        fieldOfPostalCodeElement.sendKeys("12345");

        WebElement fieldCardHolderNameElement = driver.findElement(fieldCardHolderName);
        fieldCardHolderNameElement.click();
        fieldCardHolderNameElement.sendKeys("NameTest");

        WebElement termsAndConditionsElement = driver.findElement(termsAndConditions);
        termsAndConditionsElement.click();

        WebElement selectCurrencyElement = driver.findElement(selectCurrency);
        selectCurrencyElement.click();

    }

    public void checkResultOfPayment(){
        WebElement answerAboutIncorrectDataElement = driver.findElement(answerAboutIncorrectData);
        String answer = answerAboutIncorrectDataElement.getText();
        String expectedResult = "text";
        Assert.assertEquals(answer, expectedResult);
        System.out.println("Result: " + answer);
    }
}
