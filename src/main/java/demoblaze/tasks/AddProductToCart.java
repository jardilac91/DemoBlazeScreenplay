package demoblaze.tasks;

import demoblaze.utils.ConvertAmountToInt;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import net.serenitybdd.screenplay.actions.DriverTask;

import java.util.ArrayList;
import java.util.List;

import static demoblaze.ui.Header.CART_BUTTON;
import static demoblaze.ui.HomePage.getProducts;
import static demoblaze.ui.HomePage.selectProductByIndex;
import static demoblaze.ui.ProductPage.*;
import static demoblaze.utils.ConvertAmountToInt.convertAmountToInt;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddProductToCart implements Performable {

    public static List<String> products_name = new ArrayList<>();
    public static List<Integer> product_prices = new ArrayList<>();

    public static int total=0;
    public static int product_price;

    private Integer quantity;

    public AddProductToCart(){}

    public AddProductToCart(Integer quantity){
        this.quantity = quantity;
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds()
        );

        for(int index = 1; index <= quantity; index ++) {
            product_price = convertAmountToInt(PRODUCT_PRICE.resolveFor(actor).getText());
            product_prices.add(product_price);
            total += (product_price*quantity);
            products_name.add(PRODUCT_NAME.resolveFor(actor).getText());
            actor.attemptsTo(
                    WaitUntil.the(ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(ADD_TO_CART_BUTTON),
                    WaitUntil.the(ExpectedConditions.alertIsPresent()),
                    (new DriverTask(driver -> driver.switchTo().alert().accept()))
            );
        }
    }

    public static AddProductToCart theQuantity(Integer quantity){
        return new AddProductToCart(quantity);
    }
}
