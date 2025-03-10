package co.com.consubanco.certificacion.stepsDefinitions.web;

import co.com.consubanco.certificacion.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import java.io.IOException;
import static co.com.consubanco.certificacion.uis.StoreUserInterface.TXT_PRODUCT_CART;
import static co.com.consubanco.certificacion.uis.StoreUserInterface.TXT_TITLE_DESCRIPCION;

public class GestionProductosStepDefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("selecciono la categoría {string}")
    public void seleccionoLaCategoría(String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.enPantalla(categoria));
    }

    @Cuando("selecciono el producto {string}")
    public void seleccionoElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarProducto.enPantalla(producto));
    }

    @Entonces("podré ver el detalle del producto con la etiqueta {string}")
    public void podréVerElDetalleDelProductoConLaEtiqueta(String descripcion) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_TITLE_DESCRIPCION), WebElementStateMatchers.containsText(descripcion)));
    }

    @Cuando("agrego el producto al carrito")
    public void agregoElProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProducto.alCarrito());
    }

    @Cuando("accedo a la sección Cart desde el menú")
    public void accedoALaSecciónCartDesdeElMenú() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCarritoDeCompras.enLaPlataforma());
    }

    @Entonces("podré ver el producto {string} agregado en mi carrito de compras")
    public void podréVerElProductoAgregadoEnMiCarritoDeCompras(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRODUCT_CART.of(producto)), WebElementStateMatchers.containsText(producto)));
    }

    @Cuando("elimino el producto {string} del carrito")
    public void eliminoElProductoDelCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarProducto.enPantalla(producto));
    }

    @Entonces("el producto {string} desaparecerá del listado")
    public void elProductoDesapareceráDelListado(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(TXT_PRODUCT_CART.of(producto)), WebElementStateMatchers.isNotVisible()));
    }
}
