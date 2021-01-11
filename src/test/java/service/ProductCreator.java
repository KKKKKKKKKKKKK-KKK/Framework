package service;

import model.Product;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_NAME="testdata.product.%s.name";

    public static Product getProduct(String productId){
        String productName = String.format(TESTDATA_PRODUCT_NAME, productId);
        return new Product(TestDataReader.getTestData(productName));
    }

}
