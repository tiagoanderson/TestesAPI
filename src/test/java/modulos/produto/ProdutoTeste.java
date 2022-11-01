package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDatafactory;
import groovy.lang.GString;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ComponentePojo;
import pojo.ProdutoPojo;
import pojo.UsuarioPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Teste de API Rest do modulo de Produto")
public class ProdutoTeste {
    private String token;
    @BeforeEach
    public void beforeach(){
        //Dados da conexão APi Lojinha
        baseURI ="http://165.227.93.41/";
        basePath ="/lojinha";
        //Obter Token de acesso


        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDatafactory.criarUsuarioAdm())
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
        //Verificando se token foi pego
        //System.out.println(token);
    }

    @Test
    @DisplayName("Validar os limites proibidos do valor do produto")
    public void testValidarLimitesProibidosValorProduto(){
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body( ProdutoDataFactory.criarprodutoValor(7000.01))
                .when()
                        .post("/v2/produtos")
                .then()
                    //Teste
                    .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }


    @Test
    @DisplayName("Validar mensagem produto cadastrado com sucesso")
    public void testValidarCadastrocomsucesso(){
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body( ProdutoDataFactory.criarprodutoValor(7000.02))
                .when()
                .post("/v2/produtos")
                .then()
                //Teste
                .assertThat()
                .body("message", equalTo("Produto adicionado com sucesso"))
                .statusCode(201);
    }



}
