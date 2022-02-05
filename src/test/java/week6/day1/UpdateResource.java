package week6.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateResource extends BaseClass{
	
	@Test(dependsOnMethods = {"week6.day1.CreateNewResource.createResource"})
	public void updateTheResource() {
		
		//RestAssured.baseURI=uri;
		
	//	RestAssured.authentication = RestAssured.oauth2("00D2w00000ABvdk!AQ0AQCY7Jrf1NTYJAjHH_1LeT0V7V8OfU72B2UlaAVDS2HdlQnppnkrN5q6n45imBGZeGDJv_Hw8mBXuDmCSDOKpsUvtpRUd");

		
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(new File("./data/updateContact.json"))
		.patch(resources_end_point_others+id)
		.then()
		.assertThat()
		.statusCode(204);}

}
