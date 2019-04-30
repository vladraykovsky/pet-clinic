package com.pet.clinic.petclinic.controllers;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/owners")
public class OwnerController {

  private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/create-or-update-owner-form";
  private final OwnerService ownerService;

  @InitBinder
  public void setAllowedFields(WebDataBinder webDataBinder){
    webDataBinder.setDisallowedFields("id");
  }


  @GetMapping("/find")
  public String find(Model model) {
    model.addAttribute("owner", Owner.builder().build());
    return "owners/find-owners";
  }

  @GetMapping
  public String processFindForm(Owner owner, BindingResult result, Model model){
    if (owner.getLastName() == null) {
      owner.setLastName(""); // empty string signifies broadest possible search
    }

    // find owners by last name
    List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

    if (results.isEmpty()) {
      // no owners found
      result.rejectValue("lastName", "notFound", "not found");
      return "owners/find-owners";
    } else if (results.size() == 1) {
      // 1 owner found
      owner = results.get(0);
      return "redirect:/owners/" + owner.getId();
    } else {
      // multiple owners found
      model.addAttribute("selections", results);
      return "owners/owners-list";
    }
  }


  @GetMapping("/{id}")
  public ModelAndView getById(@PathVariable Long id){
      ModelAndView modelAndView = new ModelAndView("owners/owner-details");
      modelAndView.addObject("owner", ownerService.findById(id));
      return modelAndView;
  }


  @GetMapping("/new")
  public String initCreationForm(Model model) {
    model.addAttribute("owner", Owner.builder().build());
    return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
  }

  @PostMapping("/new")
  public String processCreationForm(@Valid Owner owner, BindingResult result) {
    if (result.hasErrors()) {
      return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    } else {
      Owner savedOwner =  ownerService.save(owner);
      return "redirect:/owners/" + savedOwner.getId();
    }
  }


  @GetMapping("/{ownerId}/edit")
  public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
    model.addAttribute(ownerService.findById(ownerId));
    return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
  }

  @PostMapping("/{ownerId}/edit")
  public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
    if (result.hasErrors()) {
      return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    } else {
      owner.setId(ownerId);
      Owner savedOwner = ownerService.save(owner);
      return "redirect:/owners/" + savedOwner.getId();
    }
  }



}
