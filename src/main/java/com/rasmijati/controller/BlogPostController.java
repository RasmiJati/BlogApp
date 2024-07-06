/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.BlogPost;
import com.rasmijati.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api/v1")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogposts")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/blogposts/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost not found"));
        return ResponseEntity.ok(blogPost);
    }

    @PostMapping("/blogposts")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.createBlogPost(blogPost);
    }

    @PutMapping("/blogposts/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostDetails) {
        BlogPost updatedBlogPost = blogPostService.updateBlogPost(id, blogPostDetails);
        return ResponseEntity.ok(updatedBlogPost);
    }

    @DeleteMapping("/blogposts/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
