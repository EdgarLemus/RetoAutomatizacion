package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.BTN_CATEGORY;

public class SeleccionarCategoria implements Task {

    private String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CATEGORY.of(categoria)),
                DetenerTiempo.deEjecucion(2)
        );
    }

    public static SeleccionarCategoria enPantalla(String categoria) {
        return Instrumented.instanceOf(SeleccionarCategoria.class).withProperties(categoria);
    }
}
