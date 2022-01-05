package rozetkaPages;

import core.decorator.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SortedPage extends DefaultPage {

    @FindBy(css = ".catalog-settings__sorting select")
    private Element sortButton;

    @FindBy(xpath = "//div[contains(@class, 'goods-tile ng-star-inserted')]")
    private List <WebElement> itemsOnThePage;

    public void sortByPriceDecrease(){
        Select sortingSelect = new Select(sortButton);
        sortingSelect.selectByIndex(2);
    }

    public WebElement getFirstElement(){
        return itemsOnThePage.get(0);
    }

    public void clickOnFirstElement(){
        getFirstElement().click();
    }

    public SortedPage() {
        super();
    }
}
