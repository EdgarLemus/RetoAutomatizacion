package co.com.consubanco.certificacion.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.*;
import static co.com.consubanco.certificacion.utils.Utilidades.capitalize;

public class RealizarRegistro implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_SIGN_UP),
                Enter.theValue((capitalize(Faker.instance().name().firstName()) + capitalize(Faker.instance().name().lastName()) + Faker.instance().number().digits(3)).trim()).into(TXT_USERNAME),
                Enter.theValue(Faker.instance().animal()+Faker.instance().number().digits(3)).into(TXT_PASSWORD),
                Click.on(BTN_REGISTRO)
        );

    }

    public static RealizarRegistro enLaPlataforma() {
        return Instrumented.instanceOf(RealizarRegistro.class).withProperties();
    }
}
