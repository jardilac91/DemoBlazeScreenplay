package demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static demoblaze.ui.CartPage.*;
import static demoblaze.ui.Header.CART_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateShoppingCartLogedUser implements Performable {
    public static List<String> product_name_shopping_cart = new ArrayList<>();
    public static List<Integer> product_price_shopping_cart = new ArrayList<>();
    public static Integer total_purchase = 0;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CART_BUTTON),
                WaitUntil.the(PLACE_ORDER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                WaitUntil.the(TOTAL_PURCHASE, isVisible()).forNoMoreThan(10).seconds()
        );
        total_purchase = Integer.parseInt(TOTAL_PURCHASE.resolveFor(actor).getText());
        for (int product = 1; product <= getAllProductNames(actor).size(); product ++){
            product_name_shopping_cart.add(
                    productName(
                            String.valueOf(product)
                    ).resolveFor(actor).getText()
            );
            product_price_shopping_cart.add(
                    Integer.parseInt(
                            productPrice(
                                    String.valueOf(product)
                            ).resolveFor(actor).getText())
            );
        }
    }

    public static ValidateShoppingCartLogedUser validateShoppingCartLogedUser() {
        return new ValidateShoppingCartLogedUser();
    }
}
