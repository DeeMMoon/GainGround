package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String blogMain(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("posts",postService.authorPosts(user.getId()) );
        return "post-home";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String blogAddForm(
            @AuthenticationPrincipal User user,
                              @RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text, Model model){
        Post post = new Post(title,anons,full_text,user);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{post_id}")
    public String blogDetail(@PathVariable(value = "post_id") long postId, Model model){
        if(!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(postId);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
       return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long postId, Model model){
        if(!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(postId);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long postId, @RequestParam String title, @RequestParam String anons,
                                 @RequestParam String full_text, Model model){
        Post post = postRepository.findById(postId).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long postId, Model model){
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
