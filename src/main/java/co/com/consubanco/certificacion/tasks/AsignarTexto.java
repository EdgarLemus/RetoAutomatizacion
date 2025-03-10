package co.com.consubanco.certificacion.tasks;

import co.com.consubanco.certificacion.uis.FacilitoUserInterface;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.consubanco.certificacion.uis.FacilitoUserInterface.*;

public class AsignarTexto implements Task {

    private String texto;

    public AsignarTexto(String texto) {
        this.texto = texto;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(texto).into(TXT_CLIPBOARD),
                Click.on(BTN_SET_CLIPBOARD),
                Click.on(BTN_REFRESH_CLIPBOARD)
        );
    }

    public static AsignarTexto enLaPlataforma(String texto) {
        return Instrumented.instanceOf(AsignarTexto.class).withProperties(texto);
    }
}
