package TestCases;

import BaseTests.ViaCep.BaseTestViaCep;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ConsultaCepFormatoInvalido extends BaseTestViaCep {

    @Test
    public void consultaCepFormatoInvalido(){
        String cep = "99888-888";
        given()
                .spec(requestSpec)
                .when()
                    .get("/ws/" + cep + "/json/")
                .then()
                    .spec(responseSpec)
                    .log().all();
    }
}
