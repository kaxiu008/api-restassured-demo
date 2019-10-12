package intTest

import org.junit.Test
import org.junit.BeforeClass
import static org.hamcrest.Matchers.*
import static io.restassured.module.jsv.JsonSchemaValidator.*
import io.restassured.response.Response
import testServices.CategoryTestService
import testServices.CategoryTestJsonPath

public class CategoryTest {

    private static Response categoryDetailResponse;
    private static CategoryTestService testService;
    private static CategoryTestJsonPath jsonPath;

    @BeforeClass
    public static void Setup() {
        //Initialize services for Category API
        testService = new CategoryTestService();
        jsonPath = new CategoryTestJsonPath();
    }
	
    @Test
    void testCategory() {
        //Send a Get Request to Category API and get Response
        categoryDetailResponse = testService.getCategoryDetails();

        //Verify the API JSON Schema, Name, CanRelist, Promotion fields in the response
        categoryDetailResponse.then().assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(testService.jsonSchema))
                .body(jsonPath.name, equalTo("Carbon credits"))
                .body(jsonPath.canRelist, equalTo(true))
                .body(jsonPath.findPromotionDescriptionByName("Gallery"), containsString("2x larger image") )
    }
}