package demoblaze.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static demoblaze.ui.Header.LOGIN_BUTTON;
import static demoblaze.ui.HomePage.selectProductByName;
import static demoblaze.ui.LoginModal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Login {

    protected static String username = "jardilac91";
    protected static String password = "Pragma2023*";

    public static Performable onStore() {
        return Task.where("{0} Inicia sesion",
                actor -> actor.attemptsTo(
                        Click.on(LOGIN_BUTTON),
                        WaitUntil.the(LOGIN_MODAL, isVisible()).forNoMoreThan(10).seconds(),
                        WaitUntil.the(LOGIN_BUTTON_MODAL, isClickable()).forNoMoreThan(10).seconds(),
                        Enter.theValue(username).into(USERNAME_INPUT),
                        Enter.theValue(password).into(PASSWORD_INPUT),
                        Click.on(LOGIN_BUTTON_MODAL),
                        WaitUntil.the(LOGIN_MODAL, isNotVisible()).forNoMoreThan(10).seconds()
                ));
    }
}