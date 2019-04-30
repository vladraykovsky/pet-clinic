package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.repositories.OwnerRepository;
import com.pet.clinic.petclinic.repositories.PetRepository;
import com.pet.clinic.petclinic.repositories.PetTypeRepository;
import com.pet.clinic.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class OwnerServiceJpa implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;


  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public Owner save(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public Owner findById(Long aLong) {
    return ownerRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().iterator().forEachRemaining(owners::add);
    return owners;
  }

  @Override
  public void deleteById(Long aLong) {
    ownerRepository.deleteById(aLong);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public List<Owner> findAllByLastNameLike(String lastName) {
    return ownerRepository.findAllByLastNameLike(lastName);
  }
}
