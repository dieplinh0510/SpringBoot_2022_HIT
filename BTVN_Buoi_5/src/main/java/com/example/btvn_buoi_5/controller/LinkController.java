package com.example.btvn_buoi_5.controller;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.example.btvn_buoi_5.constants.Constants;
import com.example.btvn_buoi_5.exception.DuplicateException;
import com.example.btvn_buoi_5.model.Link;
import com.example.btvn_buoi_5.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Random;

@Controller
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping
    public ResponseEntity<?> getLinks(){
        List<Link> links = linkRepository.findAll();
        return ResponseEntity.status(200).body(links);
    }

    @PostMapping
    public ResponseEntity<?> postLink(@RequestParam(value = "originalLink") String originalLink){

        Link link = new Link();
        Random random = new Random();

        Link oldLink = linkRepository.findLinkByOriginalLink(originalLink);
        if (oldLink != null){
            return ResponseEntity.status(200).body(oldLink);
        }

        try {
            link.setShortedLink(NanoIdUtils.randomNanoId(random, Constants.ALPHABET, Constants.LENGTH_OFF_LINK));
            link.setOriginalLink(originalLink);
            return  ResponseEntity.status(200).body(linkRepository.save(link));
        } catch (Exception ex){
            throw new DuplicateException("Trung shortedLink");
        }


    }

    @GetMapping("/{shortedLink}")
    public RedirectView getShortedLink(@PathVariable("shortedLink") String shortedLink){

        Link link = linkRepository.findLinkByShortedLink(shortedLink);
        String originalLink = link.getOriginalLink();
        RedirectView redirectView = new RedirectView(originalLink);
        return redirectView;
    }

}


