package demoblaze.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static demoblaze.ui.Header.LOGIN_BUTTON;
import static demoblaze.ui.Header.LOGOUT_BUTTON;
import static demoblaze.ui.LoginModal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logout {

    public static Performable fromStore() {
        return Task.where("{0} cierra sesion",
                actor -> actor.attemptsTo(
                        Click.on(LOGOUT_BUTTON)
                ));
    }

}
