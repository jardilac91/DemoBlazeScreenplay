package demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static demoblaze.ui.HomePage.*;
import static demoblaze.utils.SelectRandomProduct.selectRandomProduct;

public class SelectProduct{
    public static Performable any(){

        return Task.where("{0} selecciona un producto aleatorio", actor -> actor.attemptsTo(
                Click.on(
                        selectProductByIndex(
                                String.valueOf(
                                        selectRandomProduct(
                                                getProducts(actor).size())
                                )
                        )
                )
        ));
    }

    public static Performable the(String product_name){
        return Task.where("{0} selecciona una categoria y una subcategoria",
                actor -> actor.attemptsTo(
                        Click.on(selectProductByName(product_name))
                ));
    }
    public static Performable with(String category, String product_name){
        return Task.where("{0} selecciona una categoria y una subcategoria",
                actor -> actor.attemptsTo(
                        Click.on(filterProductByCategory(category)),
                        Click.on(selectProductByName(product_name))
                ));
    }





}

