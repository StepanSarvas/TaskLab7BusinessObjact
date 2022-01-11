import businessObject.AddingToBucket;
import businessObject.SearchingProducts;
import businessObject.TestAssertion;
import org.testng.annotations.DataProvider;
import Utils.jaxbParser.AllSearchData;
import Utils.jaxbParser.SearchData;
import org.testng.annotations.Test;
import Utils.jaxbParser.XMLParser;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class testCartSum extends DefaultTest {

    @DataProvider(name = "data2", parallel = true)
    public static Object[][] getData() {
        AllSearchData allSearchData = XMLParser.unmarshall();
        List<SearchData> searchDataList = allSearchData.getAllSearchData();

        Object[][] objArray = new Object[searchDataList.size()][];
        for (int i = 0; i < searchDataList.size(); i++) {
            objArray[i] = new Object[1];
            objArray[i][0] = searchDataList.get(i);
        }
        return objArray;
    }

    @Test(dataProvider = "data2")
    public void checkPrice(SearchData searchData) {
        SearchingProducts searchingProducts = new SearchingProducts();
        searchingProducts.searchingProducts(searchData.getKeyword(), searchData.getBrandName());

        AddingToBucket addingToBucket = new AddingToBucket();
        addingToBucket.addingToBucket(addingToBucket.getProductPage());

        TestAssertion testAssertion = new TestAssertion();
        testAssertion.assertCorrectPrice(searchData.getPriceValidation(), addingToBucket);
    }

}
