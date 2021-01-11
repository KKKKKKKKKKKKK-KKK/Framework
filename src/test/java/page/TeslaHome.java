package page;


import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ProductCreator;

public class TeslaHome extends Page {

    public static final String MAIN_PAGE_URL= "https://www.tesla.com/";

    @FindBy (xpath = "//li[@class='region-item i18n-en_us']/child::a[@title='United States' and text()='United States']")
    private WebElement choiseRegion;



    @FindBy (xpath = "//a[@class='tds-btn tds-o-btn tds-btn--outline tds-btn--white tcl-button' and text()='Order Now']/parent::div[@class='hero-callouts--button cmp-animate--to_reveal cmp-animate--revealed']")
    private WebElement orderNow;

    @FindBy (xpath = "//h2[@class='packages-options--nav-title']/child::span[text()='Payment']")
    private WebElement payment;

    public TeslaHome(WebDriver driver) {
        super(driver);
    }


    public TeslaHome openPage() {

        this.driver.get(MAIN_PAGE_URL);

       // new WebDriverWait(driver, TIMEOUT).until(jQueryAJAXCompleted());
        return this;
    }
    public TeslaHome choiseRegionOnMainPage(){
        (new WebDriverWait(driver, 50L)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='locale-modal' and @open]")));
        new WebDriverWait(driver, 50L).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='region-item i18n-en_us']/child::a[@title='United States' and text()='United States']")));
        //new WebDriverWait(driver,10).until(CustomWait.jQueryAJAXsCompleted());
        choiseRegion.click();
        return this;
    }
    public TeslaOrderPage choiseModelAndAddToOrder(String model){
        //new WebDriverWait(driver,10).until(CustomWait.jQueryAJAXsCompleted());
        Product prod= new ProductCreator().getProduct(model);
        System.out.println(prod.getName());
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prod.getName()))).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Order Now' and @data-gtm-event='drawer-interaction' and @class='tds-btn tcl-button tds-btn--outline tds-btn--white']"))).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment']/ancestor::li"))).click();

        return new TeslaOrderPage(driver);
    }
}
