package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.RoleRedirecter;
import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.PostRepository;
import com.gainground.gainGroung.repository.ProfileRepository;
import com.gainground.gainGroung.repository.UserRepository;
import com.gainground.gainGroung.service.PostService;
import com.gainground.gainGroung.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RatingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/rating")
    public String userList(@AuthenticationPrincipal User user,Model model) {
        List<ProfileEmpl> profileEmpls = profileService.allProfilesEmpl();
        model.addAttribute("allProfiles", profileEmpls);
        return RoleRedirecter.redirecter(user, "rating-emplr", "rating-empl");
    }
    @GetMapping("/rating/{profile_id}")
    public String blogDetail(@PathVariable(value = "profile_id") long profId, Model model, @AuthenticationPrincipal User user){
        if(!profileRepository.existsById(profId)){
            return "redirect:/rating";
        }
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(profId);
        model.addAttribute("profile",profileEmpl);
        return RoleRedirecter.redirecter(user,"profile-rating-emplr","profile-rating-empl");
    }
    @GetMapping("/rating/blog/{profile_id}")
    public String ratingBlog(@PathVariable(value = "profile_id") long profId, Model model, @AuthenticationPrincipal User user){
        User findUser;
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(profId);
        findUser = userRepository.findByProfileEmpl(profileEmpl);
        model.addAttribute("posts",postService.authorPosts(findUser.getId()));
        return RoleRedirecter.redirecter(user,"post-rating-emplr","post-rating-empl");
    }
    @GetMapping("/rating/blog/posts/{el_id}")
    public String ratingBlogPost(@PathVariable(value = "el_id") long postId, Model model, @AuthenticationPrincipal User user){
        if(!postRepository.existsById(postId)){
            return "redirect:/rating/blog";
        }
        Optional<Post> post = postRepository.findById(postId);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("posts",res);
        return RoleRedirecter.redirecter(user,"rating-post-details-emplr","rating-post-details-empl");
    }
}