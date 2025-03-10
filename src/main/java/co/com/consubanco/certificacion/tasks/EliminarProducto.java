package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.uis.StoreUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EliminarProducto implements Task {

    private String producto;

    public EliminarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(StoreUserInterface.BTN_DELETE_PRODUCT.of(producto))
        );
    }

    public static EliminarProducto enPantalla(String producto) {
        return Instrumented.instanceOf(EliminarProducto.class).withProperties(producto);
    }
}
