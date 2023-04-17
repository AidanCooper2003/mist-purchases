package edu.iu.c322.mist.purchases.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping
    public String greetings() {
        return "Greetings";
    }

}
