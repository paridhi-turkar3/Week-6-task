package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.savePost(post);
    }

    @GetMapping("/test")
    public Post testPost() {
        Post post = new Post();
        post.setTitle("Test Blog");
        post.setContent("Spring Boot Working");
        post.setAuthor("Paridhi");
        return service.savePost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return service.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        service.deletePost(id);
        return "Post deleted successfully";
    }
}

