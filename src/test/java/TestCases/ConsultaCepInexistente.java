package TestCases;

import BaseTests.BaseTestViaCep;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConsultaCepInexistente extends BaseTestViaCep {
    @Test
    public void consultaCepInexistente(){
        String cep = "99999999";
        given()
                .spec(requestSpec)
        .when()
                .get("/ws/" + cep + "/json/")
        .then()
                .spec(responseSpec)
                .log().all();
    }
}
