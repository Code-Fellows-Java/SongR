package com.ianmcshoeSongr.songrmcshoe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    // home route
    // old way
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        return "Hello World";
    }

    // new way

    @GetMapping("/Oy")
    public String getHi() {
        return "hello";
    }

    @GetMapping("/sayhello/{name}")
    @ResponseBody
    public String  sayHello(@PathVariable String name) {
        return "Hello" + " " + name;
    }

    // route with URL params using SpringModel(Not MVC)

    @GetMapping("/model/{name}")
    public String modelMe(@PathVariable String name , Model m) {
        m.addAttribute("name", name);
        m.addAttribute("age", 70);
        return "";
    }

}
