package co.com.consubanco.certificacion.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.Map;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.*;

public class RealizarLogin implements Task {

    private Map<String, String> values;

    public RealizarLogin(Map<String, String> values) {
        this.values = values;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOG_IN),
                Enter.theValue(values.get("Username")).into(TXT_LOGIN_USERNAME),
                Enter.theValue(values.get("Password")).into(TXT_LOGIN_PASSWORD),
                Click.on(BTN_LOGIN),
                Wait.until(WebElementQuestion.the(TXT_NAME_USERNAME), WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static RealizarLogin enLaPlataforma(Map<String, String> values) {
        return Instrumented.instanceOf(RealizarLogin.class).withProperties(values);
    }
}
