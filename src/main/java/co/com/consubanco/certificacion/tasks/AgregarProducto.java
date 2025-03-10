package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.BTN_ADD_CART;

public class AgregarProducto implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD_CART),
                DetenerTiempo.deEjecucion(1)
        );
    }

    public static AgregarProducto alCarrito() {
        return Instrumented.instanceOf(AgregarProducto.class).withProperties();
    }
}
