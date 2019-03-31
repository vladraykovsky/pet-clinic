package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.model.PetType;
import com.pet.clinic.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public PetType findByLastName(String lastName) {
    return null;
  }

  @Override
  public PetType save(PetType t) {
    return super.save(t);
  }

  @Override
  public void delete(PetType object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public PetType findById(Long id) {
    return super.findById(id);
  }

}
