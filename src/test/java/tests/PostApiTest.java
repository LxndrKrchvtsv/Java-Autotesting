package tests;

import api.domain.models.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostApiTest extends BaseApiTest {
	@Test(description = "GET /posts - Getting a list of all posts")
	public void testGetAllPosts() {
		Response response = postService.getAllPosts();

		response.then().statusCode(200);

		List<Post> posts = response.jsonPath().getList("", Post.class);
		Assert.assertFalse(posts.isEmpty(), "The list of posts must not be empty");

		Assert.assertNotNull(posts.get(0).getId(), "ID The post should not be null");
	}

	@Test(description = "POST /posts - Creating a new post")
	public void testCreateNewPost() {
		Post newPost = Post.builder()
				.userId(1)
				.title("AQA Task 9")
				.body("Testing API with Rest Assured")
				.build();

		Response response = postService.createPost(newPost);

		response.then().statusCode(201);

		Post createdPost = response.as(Post.class);
		Assert.assertEquals(createdPost.getTitle(), newPost.getTitle(), "Title in a response does not match the one " +
				"sent");

		Assert.assertNotNull(createdPost.getId(), "The server should have returned the ID of the created post.");
	}

	@Test(description = "GET /posts/{id} - Receiving a non-existent post")
	public void testGetNonExistentPost() {
		int nonExistentId = 9999;
		Response response = postService.getSinglePost(nonExistentId);

		response.then().statusCode(404);

		String body = response.getBody().asString();
		Assert.assertEquals(body, "{}", "The response body for a non-existent resource must be empty JSON");
	}

	@Test(description = "POST /posts - Attempt to create a post with an invalid data type (logic test)")
	public void testCreatePostWithEmptyBody() {
		Post emptyPost = new Post();
		Response response = postService.createPost(emptyPost);

		response.then().statusCode(201);

		Post result = response.as(Post.class);
		Assert.assertNull(result.getTitle(), "Title should be null when empty query");
	}
}