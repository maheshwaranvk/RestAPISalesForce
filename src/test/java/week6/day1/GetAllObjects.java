package week6.day1;


import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllObjects extends BaseClass{
	
	@Test
	public void getObjects() {
	
		Response response = RestAssured.given()
		.log().all()
		.accept(ContentType.JSON)
		.get("services/data/v20.0/sobjects")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		List<String> list = 	response.jsonPath().getList("sobjects.label");
		
	//	System.out.println(response.jsonPath().get("sobjects.urls[3].rowTemplate"));
		
	/*	for (String string : list) {
			if(string.equals(resource)) {
				
			System.out.println( response.jsonPath().get(string+".urls.rowTemplate"));
				
}*/
		
		for (int i=0;i<list.size();i++) {
			if(list.get(i).equals(resource)==true) {
				
				//System.out.println(response.jsonPath().get("sobjects.urls["+i+"].rowTemplate"));
				resources_end_point_others= response.jsonPath().get("sobjects.urls["+i+"].rowTemplate").toString().substring(0, 38);
				
				resources_end_point_post = response.jsonPath().get("sobjects.urls["+i+"].sobject").toString();
				
				resources_end_point_getAll = response.jsonPath().get("sobjects.urls["+i+"].describe").toString();
			}
			
		}
		
		System.out.println(resources_end_point_others);
		System.out.println(resources_end_point_post);
		System.out.println(resources_end_point_getAll);
			
			
			}
		}
			
		//}
	



