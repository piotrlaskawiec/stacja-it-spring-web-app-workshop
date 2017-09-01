package it.stacja.springfunapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {

        model.addAttribute("msg", "Hello World!");
        model.addAttribute("names", Arrays.asList("Test1", "Test2", "Test3"));
        return "home";

    }
}
