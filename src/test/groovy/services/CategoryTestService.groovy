package testServices

import static io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import static helpers.TestHelpers.*

public class CategoryTestService {
    
    public static String jsonSchema = "category-details-schema.json"

    //Set a QueryParameter and create a RequestSpecification
    public static RequestSpecification createRequestSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
        builder.addQueryParam("catelogue", "false")
        return builder.build()
    }

    //Send a Get Request to Category API and get Response
    public Response getCategoryDetails() {	
        RequestSpecification spec = createRequestSpec()
        Response response = getResponse(spec,"/v1/Categories/6327/Details.json")
        return response
    }
}
