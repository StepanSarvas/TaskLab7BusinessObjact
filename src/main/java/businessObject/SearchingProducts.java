package businessObject;

import org.openqa.selenium.WebDriver;
import rozetkaPages.MainPage;
import rozetkaPages.SearchResultPage;
import rozetkaPages.SortedPage;
import sun.applet.Main;

public class SearchingProducts {
    private static final int TIME_TO_WAIT = 25;
    private MainPage mainPage = new MainPage();
    private SearchResultPage searchResultPage = new SearchResultPage();
    private SortedPage sortedPage = new SortedPage();

    public void searchingProducts(String keyword, String brandName){
        mainPage.searchByCategory(keyword);
        searchResultPage.waitPageLoad(TIME_TO_WAIT);
        searchResultPage.scrollToSidebarSearch();
        searchResultPage.waitElementLoad(TIME_TO_WAIT, getSearchResultPage().getSidebarSearch());
        searchResultPage.searchByBrand(brandName);
        searchResultPage.waitOneElementLeft(TIME_TO_WAIT, getSearchResultPage().getCheckboxList());
        searchResultPage.waitElementLoad(TIME_TO_WAIT, getSearchResultPage().getBrandCheckbox());
        searchResultPage.clickOnBrandCheckbox();
        sortedPage.sortByPriceDecrease();
        sortedPage.waitPageLoad(TIME_TO_WAIT);
        sortedPage.waitElementLoad(TIME_TO_WAIT, getSortedPage().getFirstElement());
        sortedPage.clickOnFirstElement();
    }

    public SearchingProducts() {

    }

    public MainPage getMainPage(){ return mainPage;}
    public SearchResultPage getSearchResultPage(){ return searchResultPage; }
    public SortedPage getSortedPage(){ return sortedPage; }
}
