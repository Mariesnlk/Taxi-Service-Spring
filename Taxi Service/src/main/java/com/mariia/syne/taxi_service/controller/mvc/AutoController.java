package com.mariia.syne.taxi_service.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/autos")
public class AutoController {


    @GetMapping("/list")
    public String showAutosList(){

        return "auto/list";
    }


    @GetMapping("/list-active")
    public String showActiveAutosList(){

        return "auto/list-active";
    }

    @GetMapping("/read/{auto_id}")
    public String showAutosRead(@PathVariable String auto_id, Model model){

        model.addAttribute("auto_id",auto_id);

        return "auto/read";
    }

    @GetMapping("/create")
    public String showAutosCreate(){

        return "auto/create";
    }

    @GetMapping("/update/{auto_id}")
    public String showAutosUpdate(@PathVariable String auto_id, Model model){

        model.addAttribute("auto_id",auto_id);

        return "auto/update";
    }
}
