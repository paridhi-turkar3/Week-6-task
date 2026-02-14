package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());

        return repository.save(post);
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }
}
