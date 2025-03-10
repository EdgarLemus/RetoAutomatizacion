package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.uis.FacilitoUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.consubanco.certificacion.uis.FacilitoUserInterface.BTN_CLIPBOARD_DEMO;

public class IngresarLink implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CLIPBOARD_DEMO)
        );
    }

    public static IngresarLink enLaPlataforma() {
        return Instrumented.instanceOf(IngresarLink.class).withProperties();
    }
}
