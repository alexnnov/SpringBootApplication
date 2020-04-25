package com.netcracker.controller;

import com.netcracker.model.User;
import com.netcracker.service.IUserService;
import com.netcracker.service.TextSaver;
import com.netcracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    public IUserService userService = new UserService();

   @RequestMapping(value="/userresult", method=RequestMethod.GET)
    public String getList(Model model) {
       try
       {
           List<String> userList = new ArrayList<>();
           BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
           while (reader.ready())
           {
               userList.add(reader.readLine());
           }
           model.addAttribute("userList",userList);
           reader.close();
       }
       catch (Exception e){}
        return "result";
    }

    @GetMapping("/user")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute User user){
        if(user.getAge()<0) user.setAge(0);
        if(user.getId()<0) user.setId(0);
        TextSaver.saveText(user);
        return "userresult";
    }

    @GetMapping("/search")
    public String searchForm(Model model){
        model.addAttribute("user", new User());
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(Model model,@ModelAttribute User user){
        try
        {
            List<String> userList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
            while (reader.ready())
            {
                String tmpString = reader.readLine();
                if (tmpString.contains(user.getLastName()))
                   return "positiveresult";
            }
            reader.close();
            return "negativeresult";
        }
        catch (Exception e){}

       //model.addAttribute("user", new User());
        return "result";
    }



    @GetMapping("/result")
    public String userResultSearch(Model model){
        try
        {
            List<String> userList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
            while (reader.ready())
            {
                userList.add(reader.readLine());
            }
            model.addAttribute("userList",userList);
            reader.close();
        }
        catch (Exception e){}

        return "result";
    }




}

