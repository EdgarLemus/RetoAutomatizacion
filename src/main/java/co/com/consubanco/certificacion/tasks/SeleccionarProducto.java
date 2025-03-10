package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.interactions.DetenerTiempo;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.BTN_PRODUCT;

public class SeleccionarProducto implements Task {

    private String producto;

    public SeleccionarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(BTN_PRODUCT.of(producto)),
                DetenerTiempo.deEjecucion(1)
        );
    }

    public static SeleccionarProducto enPantalla(String producto) {
        return Instrumented.instanceOf(SeleccionarProducto.class).withProperties(producto);
    }
}
