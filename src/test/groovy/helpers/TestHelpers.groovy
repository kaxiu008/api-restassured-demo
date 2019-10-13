package helpers

import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import static io.restassured.RestAssured.given
import static helpers.TestEnvironment.*

public class TestHelpers {

    /**
     * A reusable function for sending Get request and get Response.
     *
     *  @param requestSpec, a pre-existing RequestSpecification
     *  @param basePath, a pre-existing basePath
     */
    public static Response getResponse(RequestSpecification requestSpec,String basePath) {
		
        Map env = getSandbox()
        String uri = "${env.get("sandbox")}${basePath}"
         
        Response response = given()
                .spec(requestSpec)
                .when()
                .get(uri)
                .then()
                .statusCode(200)
                .extract().response()

        return response
    }

}
