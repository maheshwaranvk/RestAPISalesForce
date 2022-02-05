package week6.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteNewResource extends BaseClass{
	
	
	@Test(dependsOnMethods = {"week6.day1.UpdateResource.updateTheResource"})
	public void deleteResource() {
		
		RestAssured.given()
		.log().all()
		.delete(resources_end_point_others+id)
		.then()
		.assertThat()
		.statusCode(204);

	}

}
