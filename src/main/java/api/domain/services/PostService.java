package api.domain.services;

import api.core.ApiSpec;
import api.domain.models.Post;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostService {

	private static final String POSTS_ENDPOINT = "/posts";

	public Response getAllPosts() {
		return given()
				.spec(ApiSpec.getRequestSpec())
				.when()
				.get(POSTS_ENDPOINT);
	}

	public Response createPost(Post postBody) {
		return given()
				.spec(ApiSpec.getRequestSpec())
				.body(postBody)
				.when()
				.post(POSTS_ENDPOINT);
	}

	public Response getSinglePost(int id) {
		return given()
				.spec(ApiSpec.getRequestSpec())
				.when()
				.get(POSTS_ENDPOINT + "/" + id);
	}
}