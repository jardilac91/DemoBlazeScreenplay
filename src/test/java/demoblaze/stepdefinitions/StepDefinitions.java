package demoblaze.stepdefinitions;

import demoblaze.tasks.AddProductToCart;
import demoblaze.tasks.SelectProduct;
import demoblaze.tasks.ValidateShoppingCart;
import demoblaze.ui.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static demoblaze.tasks.ValidateShoppingCart.validateShoppingCart;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {
    @Managed()
    protected WebDriver driver;

    Actor jorge = Actor.named("Jorge");

    @Before
    public void setupActor(){
        jorge.can(BrowseTheWeb.with(driver));
    }
    @Given("El usuario ha ingresado a la pagina demoblaze.")
    public void elUsuarioHaIngresadoALaPaginaDemoblaze() {
        jorge.wasAbleTo(Open.browserOn().the(HomePage.class));
    }

    @When("El usuario selecciona un producto cualquiera.")
    public void elUsuarioSeleccionaUnProductoCualquiera() {
        jorge.attemptsTo(
                SelectProduct.any()
        );

    }
    @And("El usuario lo agrega al carrito de compras.")
    public void elUsuarioLoAgregaAlCarritoDeCompras() {
        jorge.attemptsTo(
                AddProductToCart.theQuantity(1)
        );
    }

    @When("El usuario selecciona el producto {string}")
    public void elUsuarioSeleccionaElProducto(String producto) {
        jorge.attemptsTo(
                SelectProduct.the(producto)
        );
    }

    @And("El usuario agrega la cantidad de productos {int} al carrito de compras.")
    public void elUsuarioAgregaLaCantidadDeProductosAlCarritoDeCompras(Integer cantidad) {
        jorge.attemptsTo(
                AddProductToCart.theQuantity(cantidad)
        );
    }

    @Then("El usuario debe ver la misma cantidad de productos en el carrito de compras.")
    public void elUsuarioDebeVerLaMismaCantidadDeProductosEnElCarritoDeCompras() {
        jorge.attemptsTo(
                validateShoppingCart()
        );

        jorge.should(
                seeThat(
                        "The products names has to be: ",
                        product_names -> AddProductToCart.products_name,
                        equalTo(ValidateShoppingCart.product_name_shopping_cart)
                ),
                seeThat(
                        "The products prices has to be: ",
                        product_prices -> AddProductToCart.product_prices,
                        equalTo(ValidateShoppingCart.product_price_shopping_cart)
                )

        );

        driver.quit();
    }
}
