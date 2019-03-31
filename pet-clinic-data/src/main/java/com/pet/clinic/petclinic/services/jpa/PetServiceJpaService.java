package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Pet;
import com.pet.clinic.petclinic.repositories.PetRepository;
import com.pet.clinic.petclinic.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class PetServiceJpaService implements PetService {

  private final PetRepository petRepository;

  @Override
  public Pet findByLastName(String lastName) {
    return petRepository.findByName(lastName);
  }

  @Override
  public Pet save(Pet pet) {
    return petRepository.save(pet);
  }

  @Override
  public Pet findById(Long aLong) {
    return petRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().iterator().forEachRemaining(pets::add);
    return pets;
  }

  @Override
  public void deleteById(Long aLong) {
    petRepository.deleteById(aLong);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }
}
