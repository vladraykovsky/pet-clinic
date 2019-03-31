package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.model.Person;
import com.pet.clinic.petclinic.model.Pet;
import com.pet.clinic.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {


  @Override
  public Pet findByLastName(String lastName) {
    return null;
  }

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Pet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Pet save(Pet pet) {
    return super.save(pet);
  }
}
