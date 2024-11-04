package com.example.demo.controller;


import com.example.demo.models.Post;
import com.example.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String ProductName,@RequestParam Float PriceProduct,@RequestParam String SizeProduct, Model model){
        Post post= new Post(ProductName,SizeProduct,PriceProduct);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value ="id") long id, Model model){
        Optional<Post> post= postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", post);
        return "blog-details";
    }

}
