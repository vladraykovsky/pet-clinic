package com.pet.clinic.petclinic.formaters;

import com.pet.clinic.petclinic.model.PetType;
import com.pet.clinic.petclinic.services.PetService;
import com.pet.clinic.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@AllArgsConstructor
@Component
public class PetTypeFormatter implements Formatter<PetType> {

  private final PetTypeService petTypeService;


  @Override
  public PetType parse(String s, Locale locale) throws ParseException {
    return petTypeService.findAll()
        .stream()
        .filter(pet -> pet.getName().equals(s))
        .findFirst()
        .orElse(null);
  }

  @Override
  public String print(PetType petType, Locale locale) {
    return petType.getName();
  }
}
