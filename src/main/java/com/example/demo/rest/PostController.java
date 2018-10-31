package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@RestController
@RequestMapping("post")
public class PostController {

		@Autowired
		private PostRepository postRepository;
	
		@RequestMapping(method = RequestMethod.GET)
		public List<Post> getAll() {
			return postRepository.findAll();
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public Post save(@RequestBody Post post) {
			Post newPost = new Post();
			newPost.setMessage(post.getMessage());
			return postRepository.save(newPost);
		}
}
