package com.pet.clinic.petclinic.controllers;


import com.pet.clinic.petclinic.model.Pet;
import com.pet.clinic.petclinic.model.Visit;
import com.pet.clinic.petclinic.services.PetService;
import com.pet.clinic.petclinic.services.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
@AllArgsConstructor
public class VisitController {

  private final VisitService visitService;
  private final PetService petService;


  @InitBinder
  public void dataBinder(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");

    dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException{
        setValue(LocalDate.parse(text));
      }
    });
  }

  @ModelAttribute("visit")
  public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
    Pet pet = petService.findById(petId);
    model.put("pet", pet);
    Visit visit = new Visit();
    pet.getVisits().add(visit);
    visit.setPet(pet);
    return visit;
  }

  // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
  @GetMapping("/owners/*/pets/{petId}/visits/new")
  public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {
    return "pets/createOrUpdateVisitForm";
  }

  // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
  @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
    if (result.hasErrors()) {
      return "pets/createOrUpdateVisitForm";
    } else {
      visitService.save(visit);

      return "redirect:/owners/{ownerId}";
    }
  }

}
