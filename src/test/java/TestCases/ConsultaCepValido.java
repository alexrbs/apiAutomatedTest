package TestCases;

import BaseTests.ViaCep.BaseTestViaCep;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Models.BodyViaCepModel.createEmptyValuesFile;
import static Models.BodyViaCepModel.createResponseBodyFile;
import static Utils.FileOperations.createFile;
import static io.restassured.RestAssured.given;

public class ConsultaCepValido extends BaseTestViaCep {

    /*
    Cenário: Consulta CEP valido
    Dado que: o usuário inseri um CEP válido
    Quando: o serviço é consultado
    Então: é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge.
     */

    @Test
    public void consultaCepValido(){
        String cep = "91060900";
        Response resposta =
        given()
                .spec(requestSpec)
        .when()
                .get("/ws/" + cep + "/json/")
        .then()
                .spec(responseSpec)
                .extract().response();

        String[] data = {"cep", "logradouro", "complemento", "bairro", "localidade", "uf", "ibge"};

        for (int i = 0; i < data.length; i++){
            System.out.println(data[i] + ": " + resposta.then().extract().path(data[i]).toString());
        }
    }

    @Test
    public void testResponse(){
        String cep = "91060900";
        Response resposta =
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/ws/" + cep + "/json/")
                        .then()
                        .spec(responseSpec)
                        .extract().response();

        createFile("OnlyKeys");
        createEmptyValuesFile("OnlyKeys", resposta);

        createFile("ResponseBody");
        createResponseBodyFile("ResponseBody", resposta);
    }
}
