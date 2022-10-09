package com.octoberjava.dojosandninjas.controllers;

import com.octoberjava.dojosandninjas.models.Dojo;
import com.octoberjava.dojosandninjas.models.Ninja;
import com.octoberjava.dojosandninjas.services.DojoService;
import com.octoberjava.dojosandninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    private final DojoService dojoService;
    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    private final NinjaService ninjaService;

    //! CREATE AND SHOW ALL
    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute(value = "dojo") Dojo dojo, Model model){
        model.addAttribute("dojos", dojoService.getAll());
        return "/dojos/new.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute(value = "dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "/dojos/new.jsp";
        } else {
            dojoService.create(dojo);
            return "redirect:/dojos";
        }
    }

    //! READ SHOW ONE DOJO

    @GetMapping("/dojos/{id}")
    public String showDojo(Model model, @PathVariable("id") Long id){
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/show.jsp";
    }

    //! CREATE NINJA

    @GetMapping("/ninjas")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        model.addAttribute("dojos", dojoService.getAll());
        return "/ninjas/new.jsp";
    }

    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result){
        String id = String.valueOf(ninja.getDojo().getId());
        if(result.hasErrors()){
            return "/ninjas/new.jsp";
        } else {
            ninjaService.create(ninja);
            return String.format("redirect:/dojos/%s", id);
        }
        
        
    }
}
