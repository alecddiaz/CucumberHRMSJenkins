package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class HardCodedExamples {

    /*
    * Given - preparing the request
    *
    * When- making the request/making the call/hitting the endpoint
    *
    * Then- verification/ assertions
    * */

    @Test
    public void sampleTest() {
        //Base URL
        String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";


        RequestSpecification preparedRequest=given().header("Authorization",
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjYzODk3MzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjQzMjkzOSwidXNlcklkIjoiMjg3OSJ9.5wUjER4VWy7oq3ui9ajS7JPmBn1F_pFd4hBVNi2VHlc")
                .header("Content-Type","application/json")
                .queryParam("employee_id","21199A");

        Response response=preparedRequest.when().get("/getOneEmployee.php");

        System.out.println(response.asString());

    }
}
