package rozetkaPages;

import core.decorator.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends DefaultPage {

    @FindBy(xpath = "//div[3]/div/rz-filter-searchline/div/input[contains(@class, 'sidebar-search__input')]")
    private Element sidebarSearch;

    @FindBy(xpath = "//div[contains(@data-filter-name, 'producer')]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-section-autocomplete/ul[2]/li/a")
    private Element brandCheckbox;

    @FindBy(xpath = "//div[contains(@data-filter-name, 'producer')]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-section-autocomplete/ul[2]/li/a")
    private List<Element> listOfBrands;

    private String checkboxList = "//div[contains(@data-filter-name, 'producer')]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-section-autocomplete/ul[2]/li/a";

    public void searchByBrand(String brandName) {
        sidebarSearch.sendKeys(brandName);
    }

    public void clickOnBrandCheckbox() {
        brandCheckbox.click();
    }

    public void scrollToSidebarSearch() {
        Actions actions = new Actions(driver);
        actions.moveToElement(sidebarSearch);
    }

    public Element getSidebarSearch() {
        return sidebarSearch;
    }

    public Element getBrandCheckbox() {
        return brandCheckbox;
    }

    public String getCheckboxList() {
        return checkboxList;
    }

    public SearchResultPage() {
        super();
    }
}
