/*
package com.netcracker.controller;

import com.netcracker.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting){
        return "result";
    }
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getUserPage(Model model){
        return "user";
    }
}
*/
