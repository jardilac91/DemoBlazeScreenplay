package demoblaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends PageObject {

    public static final Target TOTAL_PURCHASE = Target.the("total purchased").
            located(By.id("totalp"));

    public static final Target PLACE_ORDER_BUTTON = Target.the("Place order button").
            located(By.xpath("//button[contains(text(),'Place Order')]"));

    public static List<WebElementFacade> getAllProductNames(Actor actor) {
        return  Target.the("Products Names").
                located(By.xpath("//td[2]")).resolveAllFor(actor);

    }

    public static Target productName(String index){
        return Target.the("Product Name").
                located(By.xpath(String.format("//*[@id='tbodyid']/tr[%s]/td[2]", index)));
    }

    public static Target productPrice(String index){
        return Target.the("Product Name").
                located(By.xpath(String.format("//*[@id='tbodyid']/tr[%s]/td[3]", index)));
    }

    public static Target deleteProduct(String index){
        return Target.the("Product Name").
                located(By.xpath(String.format("//*[@id='tbodyid']/tr[%s]/td[4]/a", index)));
    }

}