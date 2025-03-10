package co.com.consubanco.certificacion.stepsDefinitions.api;

import co.com.consubanco.certificacion.interactions.DeleteRest;
import co.com.consubanco.certificacion.interactions.GetRest;
import co.com.consubanco.certificacion.interactions.PostRest;
import co.com.consubanco.certificacion.interactions.PutRest;
import co.com.consubanco.certificacion.questions.CodigoEstado;
import co.com.consubanco.certificacion.questions.ValidarInformacion;
import co.com.consubanco.certificacion.utils.Utilidades;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Transpose;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PetstoreStepsDefinitions {

    static Map<String, String> values;

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que tengo acceso a la API de gestión de mascotas")
    public void queTengoAccesoALaAPIDeGestiónDeMascotas() {
        OnStage.theActorCalled("").whoCan(CallAnApi.at("https://petstore.swagger.io/v2/"));
    }

    @Cuando("agrego una nueva mascota")
    public void agregoUnaNuevaMascota(@Transpose DataTable dataTable) {
        values = new HashMap<>(dataTable.asMap(String.class, String.class));
        OnStage.theActorInTheSpotlight().attemptsTo(PostRest.on().withEndPoint("pet").withBodyRequest(Utilidades.replaceVariablesBodyMap(Utilidades.readJsonFromClasspath("DataEntry/JsonApi.json"), values)));
    }

    @Entonces("la mascota debe ser .* correctamente en la API$")
    public void laMascotaDebeSerRegistradaCorrectamenteEnLaAPI(@Transpose DataTable dataTable) {
        values = new HashMap<>(dataTable.asMap(String.class, String.class));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CodigoEstado.delServicio(values.get("Status"))));
    }

    @Cuando("consulto la información de la mascota")
    public void consultoLaInformaciónDeLaMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetRest.on("pet/" + Utilidades.getProperty("ID_PET")));
    }

    @Cuando("actualizo el nombre de la mascota")
    public void actualizoElNombreDeLaMascota(@Transpose DataTable dataTable) {
        values = new HashMap<>(dataTable.asMap(String.class, String.class));
        values.put("Id", Utilidades.getProperty( "ID_PET"));
        OnStage.theActorInTheSpotlight().attemptsTo(PutRest.on().withEndPoint("pet").withBodyRequest(Utilidades.replaceVariablesBodyMap(Utilidades.readJsonFromClasspath("DataEntry/JsonApi.json"), values)));
    }

    @Entonces("debo ver el nombre {string} actualizado correctamente")
    public void deboVerElNombreActualizadoCorrectamente(String nuevoNombre) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarInformacion.enResponse(nuevoNombre)));
    }

    @Cuando("elimino la mascota")
    public void eliminoLaMascota() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteRest.on("pet/" + Utilidades.getProperty("ID_PET")));
    }
}
