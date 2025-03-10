package co.com.consubanco.certificacion.stepsDefinitions.movil;

import co.com.consubanco.certificacion.driver.AppiumDispositivoDriver;
import co.com.consubanco.certificacion.tasks.AsignarTexto;
import co.com.consubanco.certificacion.tasks.IngresarLink;
import co.com.consubanco.certificacion.tasks.IngresarLinkLoginScreen;
import co.com.consubanco.certificacion.uis.FacilitoUserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

public class FacilitoStepDefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que abro la aplicacion de facilito")
    public void queAbroLaAplicacionDeFacilito() {
        OnStage.theActorCalled("Facilito").can(BrowseTheWeb.with(AppiumDispositivoDriver.conLasCapabilities().enElDispositivo()));
    }

    @Entonces("podre observar en pantalla el texto {string}")
    public void podreObservarEnPantallaElTexto(String texto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(FacilitoUserInterface.TXT_VALIDACION.of(texto)), WebElementStateMatchers.containsText(texto)));
    }

    @Cuando("ingreso en el link Login Screen")
    public void ingresoEnElLinkLoginScreen() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarLinkLoginScreen.enLaPlataforma());
    }

    @Cuando("ingreso en el link ClipBoard Demo")
    public void ingresoEnElLinkClipBoardDemo() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarLink.enLaPlataforma());
    }

    @Cuando("escriba el texto {string} para asignarlo al portapapeles")
    public void escribaElTextoParaAsignarloAlPortapapeles(String texto) {
        OnStage.theActorInTheSpotlight().attemptsTo(AsignarTexto.enLaPlataforma(texto));
    }
}
