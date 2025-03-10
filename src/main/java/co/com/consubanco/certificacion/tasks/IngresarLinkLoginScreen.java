package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.uis.FacilitoUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class IngresarLinkLoginScreen implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FacilitoUserInterface.BTN_LOGIN_SCREEN)
        );
    }

    public static IngresarLinkLoginScreen enLaPlataforma() {
        return Instrumented.instanceOf(IngresarLinkLoginScreen.class).withProperties();
    }
}
