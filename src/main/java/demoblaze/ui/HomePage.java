package demoblaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class HomePage extends PageObject {

    public static final Target DISABLE_FILTER = Target.the("Disable Filters").
            located(By.id("cat"));
    public static final Target FILTER_BY_PHONE = Target.the("Filter by phone button").
            located(By.linkText("Phones"));

    public static final Target filterProductByCategory(String category){
        return Target.the("Filter by phone button").
                located(By.linkText(String.format("%s", category)));

    }
    public static final Target FILTER_BY_LAPTOPS = Target.the("Filter by laptops button").
            located(By.linkText("Laptops"));

    public static final Target FILTER_BY_MONITORS = Target.the("Filter by monitors button").
            located(By.linkText("Monitors"));

    public static List<WebElementFacade> getProducts(Actor actor) {
        return  Target.the("Products").
                located(By.xpath("//*[@class='col-lg-4 col-md-6 mb-4']")).resolveAllFor(actor);

    }

    public static Target selectProductByIndex(String index){
        return Target.the("product").
                located(By.xpath(String.format("//*[@class='col-lg-4 col-md-6 mb-4'][%s]/div[1]/a", index)));
    }

    public static Target selectProductByName(String product){
        return Target.the(String.format("Product %s", product)).
                located(By.partialLinkText(product));
    }


}