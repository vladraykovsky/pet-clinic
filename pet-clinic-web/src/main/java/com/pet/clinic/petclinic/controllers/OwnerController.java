package com.pet.clinic.petclinic.controllers;

import com.pet.clinic.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;



  @GetMapping
  String listOfOwner(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }


  @GetMapping("/find")
  String find(Model model) {

    return "notimplemented";
  }


}
