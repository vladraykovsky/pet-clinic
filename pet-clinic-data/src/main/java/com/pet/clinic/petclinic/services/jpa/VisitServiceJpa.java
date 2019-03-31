package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Visit;
import com.pet.clinic.petclinic.repositories.VisitRepository;
import com.pet.clinic.petclinic.services.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class VisitServiceJpa implements VisitService {

  private final VisitRepository visitRepository;


  @Override
  public Visit findByLastName(String lastName) {
    return null;
  }

  @Override
  public Visit save(Visit visit) {
    return visitRepository.save(visit);
  }

  @Override
  public Visit findById(Long aLong) {
    return visitRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().iterator().forEachRemaining(visits::add);
    return visits;
  }

  @Override
  public void deleteById(Long aLong) {
    visitRepository.deleteById(aLong);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }
}
