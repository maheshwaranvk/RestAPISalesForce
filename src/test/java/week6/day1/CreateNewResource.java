package week6.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateNewResource extends BaseClass{
	
	
	@Test(dependsOnMethods = {"week6.day1.GetAllObjects.getObjects"})
	public void createResource() {
		
		id = RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(new File("./data/createContact.json"))
		.post(resources_end_point_post)
		.jsonPath()
		.get("id").toString();

	}

}
