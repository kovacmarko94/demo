package com.example.demo.rest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PostController.class, secure = false)
public class PostControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostRepository postRepository;
	
	Post first = new Post("first");
	Post second = new Post("second");
	Post third = new Post("third");
	List<Post> posts = Arrays.asList(first, second, third);
	
	@Test
	public void getAllPostsTest() throws Exception {
		Mockito.when(postRepository
				.findAll())
				.thenReturn(posts);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/post")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc
				.perform(requestBuilder)
				.andReturn();
		String expected = "[{\"id\":null,\"message\":\"first\"},{\"id\":null,\"message\":\"second\"},{\"id\":null,\"message\":\"third\"}]";
		JSONAssert.assertEquals(
				expected, 
				result.getResponse().getContentAsString(), 
				false);
	}
}
