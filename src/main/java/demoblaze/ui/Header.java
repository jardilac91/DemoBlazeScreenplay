package demoblaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Header extends PageObject {
    public static final Target HOME_BUTTON = Target.the("Home button header").
            located(By.linkText("Home"));

    public static final Target CONTACT_BUTTON = Target.the("Contact button header").
            located(By.linkText("Contact"));

    public static final Target ABOUT_BUTTON = Target.the("About us button header").
            located(By.linkText("About us"));

    public static final Target CART_BUTTON = Target.the("Cart button header").
            located(By.linkText("Cart"));

    public static final Target LOGIN_BUTTON = Target.the("Login button header").
            located(By.linkText("Log in"));

    public static final Target LOGOUT_BUTTON = Target.the("Logout button header").
            located(By.linkText("Log out"));

    public static final Target USERNAME_TEXT = Target.the("User name text header").
            located(By.id("nameofuser"));

    public static final Target SIGN_UP_BUTTON = Target.the("Sign up button header").
            located(By.linkText("Sign up"));
}
