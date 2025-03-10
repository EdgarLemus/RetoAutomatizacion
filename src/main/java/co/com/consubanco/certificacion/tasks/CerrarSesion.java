package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.uis.StoreUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarSesion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(StoreUserInterface.BTN_LOG_OUT)
        );
    }

    public static CerrarSesion enLaPlataforma() {
        return Instrumented.instanceOf(CerrarSesion.class).withProperties();
    }
}
