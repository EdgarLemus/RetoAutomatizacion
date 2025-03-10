package co.com.consubanco.certificacion.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class DetenerTiempo implements Interaction {

    private int segundos;

    public DetenerTiempo(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        long milisegundos = segundos * 1000;
        long tiempoInicio = System.currentTimeMillis();
        long tiempoActual = 0;

        while (tiempoActual - tiempoInicio < milisegundos) {
            tiempoActual = System.currentTimeMillis();
        }
    }

    public static Performable deEjecucion(int segundos) {
        return Instrumented.instanceOf(DetenerTiempo.class).withProperties(segundos);
    }
}
