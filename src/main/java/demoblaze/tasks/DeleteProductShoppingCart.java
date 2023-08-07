package demoblaze.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static demoblaze.ui.CartPage.*;
import static demoblaze.ui.Header.CART_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DeleteProductShoppingCart implements Performable {
    public static List<WebElementFacade> shopping_cart_list = new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CART_BUTTON),
                WaitUntil.the(PLACE_ORDER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                WaitUntil.the(TOTAL_PURCHASE, isVisible()).forNoMoreThan(10).seconds()
        );
        for (int product = 1; product <= getAllProductNames(actor).size(); product ++){
            actor.attemptsTo(
                    Click.on(deleteProduct(String.valueOf(product))),
                    WaitUntil.the(deleteProduct(String.valueOf(product)), isNotVisible()).
                            forNoMoreThan(10).seconds()

            );
        }
        shopping_cart_list = getAllProductNames(actor);
    }

    public static DeleteProductShoppingCart deleteProductShoppingCart() {
        return new DeleteProductShoppingCart();
    }
}
