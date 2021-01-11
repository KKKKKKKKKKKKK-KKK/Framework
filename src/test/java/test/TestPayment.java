package test;


import org.junit.Assert;
import org.junit.Test;


import page.*;



public class TestPayment extends Common{
    @Test
    public void addProductToCard(){
        String model="model3";
        String textFromPage = new TeslaHome(driver)
                .openPage()
                .choiseRegionOnMainPage()
                .choiseModelAndAddToOrder(model)
                .fillInAllInputs("firstname","secondname","mail","phone","cardnumber","date","cvv","zip")
                .confirm()
                .getTextFromConfirm();
        Assert.assertTrue( textFromPage.equals("There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank."));
    }


}
