package demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginModal {
    public static final Target LOGIN_MODAL = Target.the("Login modal").
            located(By.id("login2"));

    public static final Target USERNAME_INPUT = Target.the("Username input").
            located(By.id("loginusername"));

    public static final Target PASSWORD_INPUT = Target.the("Password input").
            located(By.id("loginpassword"));

    public static final Target LOGIN_BUTTON_MODAL = Target.the("Password input").
            located(By.xpath("//button[contains(text(),'Log in')]"));

}