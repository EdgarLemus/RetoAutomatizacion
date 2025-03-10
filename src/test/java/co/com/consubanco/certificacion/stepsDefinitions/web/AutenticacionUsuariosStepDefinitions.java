package co.com.consubanco.certificacion.stepsDefinitions.web;

import co.com.consubanco.certificacion.driver.NavegadorWedDriver;
import co.com.consubanco.certificacion.questions.ValidarTexto;
import co.com.consubanco.certificacion.questions.ValidarTextoAlerta;
import co.com.consubanco.certificacion.tasks.CerrarSesion;
import co.com.consubanco.certificacion.tasks.RealizarLogin;
import co.com.consubanco.certificacion.tasks.RealizarRegistro;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Transpose;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static co.com.consubanco.certificacion.uis.StoreUserInterface.BTN_LOG_IN;
import static co.com.consubanco.certificacion.uis.StoreUserInterface.TXT_NAME_USERNAME;

public class AutenticacionUsuariosStepDefinitions {

    static Map<String, String> values;

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que me encuentro en la pantalla inicial de Store")
    public void queMeEncuentroEnLaPantallaInicialDeStore() {
        OnStage.theActorCalled("Duvan").can(BrowseTheWeb.with(NavegadorWedDriver.chromeHisBrowserWeb().on("https://www.demoblaze.com/index.html")));
    }

    @Cuando("realizo el registro de una nueva cuenta")
    public void realizoElRegistroDeUnaNuevaCuenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(RealizarRegistro.enLaPlataforma());
    }

    @Entonces("podré ver el mensaje de la alerta {string}")
    public void podréVerElMensajeDeLaAlerta(String textoAlerta) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTextoAlerta.enPantalla(textoAlerta)));
    }

    @Cuando("ingreso mis credenciales y accedo a la plataforma")
    public void ingresoMisCredencialesYAccedoALaPlataforma(@Transpose DataTable dataTable) {
        values = new HashMap<>(dataTable.asMap(String.class, String.class));
        OnStage.theActorInTheSpotlight().attemptsTo(RealizarLogin.enLaPlataforma(values));
    }

    @Entonces("podré ver mi nombre de usuario {string} en la esquina superior derecha")
    public void podréVerMiNombreDeUsuarioEnLaEsquinaSuperiorDerecha(String userName) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.enPantalla(TXT_NAME_USERNAME, userName)));
    }

    @Cuando("cierre la sesion en la plataforma de Store")
    public void cierreLaSesionEnLaPlataformaDeStore() {
        OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesion.enLaPlataforma());
    }

    @Entonces("se cerrará mi sesión y seré redirigido a la pantalla principal de Store")
    public void seCerraráMiSesiónYSeréRedirigidoALaPantallaPrincipalDeStore() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(BTN_LOG_IN), WebElementStateMatchers.isVisible()));
    }
}
