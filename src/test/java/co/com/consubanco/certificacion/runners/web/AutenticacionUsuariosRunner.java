package co.com.consubanco.certificacion.runners.web;

import co.com.consubanco.certificacion.runners.RunnerPersonalizado;
import co.com.consubanco.certificacion.utils.BeforeSuite;
import co.com.consubanco.certificacion.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features/web/AutenticacionUsuarios.feature",
        glue = "co.com.consubanco.certificacion.stepsDefinitions.web",
        snippets = SnippetType.CAMELCASE)
public class AutenticacionUsuariosRunner {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/web");
    }
}
