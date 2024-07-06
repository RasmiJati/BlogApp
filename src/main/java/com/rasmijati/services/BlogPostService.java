/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.services;

/**
 *
 * @author admin
 */
import com.rasmijati.model.BlogPost;
import com.rasmijati.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPostDetails) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost not found"));
        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setContent(blogPostDetails.getContent());
        return blogPostRepository.save(blogPost);
    }

    public void deleteBlogPost(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost not found"));
        blogPostRepository.delete(blogPost);
    }
}
