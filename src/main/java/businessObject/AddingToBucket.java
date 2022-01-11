package businessObject;

import rozetkaPages.ProductPage;

public class AddingToBucket {
    private static final int TIME_TO_HOLD = 30;
    private ProductPage productPage = new ProductPage();

    public void addingToBucket(ProductPage productPage){
        this.productPage = productPage;
        productPage.waitPageLoad(TIME_TO_HOLD);
        productPage.clickOnImg();
        productPage.scrollToBuyButton();
        productPage.waitElementLoad(TIME_TO_HOLD, getProductPage().getBuyButton());
        productPage.clickOnBuyButton();
        productPage.waitElementLoad(TIME_TO_HOLD, getProductPage().getCartSum());
    }

    public int getBucketSum(){
        return productPage.getCartSumValue();
    }

    public ProductPage getProductPage(){ return productPage; }

}
