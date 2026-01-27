package tests;

import api.domain.services.PostService;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
	protected PostService postService;

	@BeforeClass
	public void setup() {
		postService = new PostService();
	}
}