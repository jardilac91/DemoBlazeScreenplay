package demoblaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    public static final Target PRODUCT_NAME = Target.the("Product name").
            located(By.className("name"));

    public static final Target PRODUCT_PRICE = Target.the("Product price").
            located(By.className("price-container"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button").
            located(By.linkText("Add to cart"));

}