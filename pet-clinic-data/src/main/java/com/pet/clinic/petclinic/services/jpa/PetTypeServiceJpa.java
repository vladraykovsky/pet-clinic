package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.PetType;
import com.pet.clinic.petclinic.repositories.PetTypeRepository;
import com.pet.clinic.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class PetTypeServiceJpa implements PetTypeService {

 private final PetTypeRepository petTypeRepository;

  @Override
  public PetType findByLastName(String lastName) {
    return petTypeRepository.findByName(lastName);
  }

  @Override
  public PetType save(PetType petType) {
    return petTypeRepository.save(petType);
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().iterator().forEachRemaining(petTypes::add);
    return petTypes;
  }

  @Override
  public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }
}
