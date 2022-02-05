package week6.day1;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {
	
	public final String resource = "Contact";
	//public static String uri = "https://ap16.salesforce.com/";
	public static String resources_end_point_others,resources_end_point_post,resources_end_point_getAll;
	public static String id;
	
	@BeforeSuite
	public void setUpSalesForce() {
		
		RestAssured.baseURI= "https://ap16.salesforce.com/";;
		
		RestAssured.authentication = RestAssured.oauth2("00D2w00000ABvdk!AQ0AQCY7Jrf1NTYJAjHH_1LeT0V7V8OfU72B2UlaAVDS2HdlQnppnkrN5q6n45imBGZeGDJv_Hw8mBXuDmCSDOKpsUvtpRUd");

	}

}
