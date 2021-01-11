package page;

import model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import service.CardCreator;

public class TeslaOrderPage extends Page {


    @FindBy (xpath = "//input[@id='FIRST_NAME']")
    private WebElement firstNameInput;

    @FindBy (xpath = "//input[@id='LAST_NAME']")
    private WebElement lastNameInput;

    @FindBy (xpath = "//input[@id='EMAIL']")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@id='PHONE_NUMBER']")
    private WebElement phoneInput;

    @FindBy (xpath = "//input[@id='CREDIT_CARD']")
    private WebElement creditCardInput;

    @FindBy (xpath = "//input[@id='EXPIRATION_DATE']")
    private WebElement dateInput;

    @FindBy (xpath = "//input[@id='CVV']")
    private WebElement cvvInput;

    @FindBy (xpath = "//input[@id='BILLING_ZIPCODE']")
    private WebElement zipInput;

    @FindBy (xpath = "//button[@class='tds-btn tds-btn--blue tds-btn--large tds-btn--full' and text()='Place Order']")
    private WebElement placeOrder;

    @FindBy (xpath = "//p[@class='error credit-card--payment-error' and text()='There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank.']")
    private WebElement resaultOrder;

    protected TeslaOrderPage(WebDriver driver) {
        super(driver);
    }


    public TeslaOrderPage fillInAllInputs(String firstname,String lastname,String mail,String phone,String card3,String date,String cvv,String zip){
        //new WebDriverWait(driver,10).until(CustomWait.jQueryAJAXsCompleted());
        Card card = new CardCreator().getCardField(firstname);
        new WebDriverWait(driver, 10L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='FIRST_NAME']"))).sendKeys(card.getName());


        card = new CardCreator().getCardField(lastname);
        lastNameInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(mail);
        emailInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(phone);
        phoneInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(card3);
        creditCardInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(date);
        dateInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(cvv);
        cvvInput.sendKeys(card.getName());
        card = new CardCreator().getCardField(zip);
        zipInput.sendKeys(card.getName());
        return this;
    }
    public TeslaOrderPage confirm(){
        new WebDriverWait(driver, 10L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='tds-btn tds-btn--blue tds-btn--large tds-btn--full' and text()='Place Order']")));
        placeOrder.click();
        return this;
    }
    public String getTextFromConfirm(){
        new WebDriverWait(driver, 10L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='error credit-card--payment-error' and text()='There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank.']")));
        return resaultOrder.getText();
    }
}
