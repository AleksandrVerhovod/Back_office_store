package pages;

import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage{
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
