package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


  @Override
  public Owner findByLastName(String lastName) {
    return this.findAll()
        .stream()
        .filter(owner -> owner.getFirstName().equalsIgnoreCase(lastName))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Owner object) {
      super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(Owner owner) {
    return super.save(owner);
  }
}
