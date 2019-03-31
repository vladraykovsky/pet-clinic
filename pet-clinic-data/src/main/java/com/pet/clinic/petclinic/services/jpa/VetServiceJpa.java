package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Vet;
import com.pet.clinic.petclinic.repositories.VetRepository;
import com.pet.clinic.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class VetServiceJpa implements VetService {

  private final VetRepository vetRepository;

  @Override
  public Vet findByLastName(String lastName) {
    return vetRepository.findByLastName(lastName);
  }

  @Override
  public Vet save(Vet vet) {
    return vetRepository.save(vet);
  }

  @Override
  public Vet findById(Long aLong) {
    return vetRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().iterator().forEachRemaining(vets::add);
    return vets;
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }
}
