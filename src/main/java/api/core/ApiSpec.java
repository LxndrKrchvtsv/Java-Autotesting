package api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiSpec {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
	}
}