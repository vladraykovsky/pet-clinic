package com.pet.clinic.petclinic.controllers;

import com.pet.clinic.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/vets")
public class VetController {

  private final VetService vetService;

  @GetMapping
  public String listOfVets(Model model) {
    model.addAttribute("vets", vetService.findAll());
    return "vets/index";
  }


}
