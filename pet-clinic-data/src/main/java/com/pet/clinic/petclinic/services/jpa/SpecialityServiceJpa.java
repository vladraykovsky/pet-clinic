package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Speciality;
import com.pet.clinic.petclinic.repositories.SpecialityRepository;
import com.pet.clinic.petclinic.services.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile(value = "springdatajpa")
public class SpecialityServiceJpa implements SpecialityService {

  private final SpecialityRepository specialityRepository;

  @Override
  public Speciality findByLastName(String lastName) {
    return null;
  }

  @Override
  public Speciality save(Speciality speciality) {
    return specialityRepository.save(speciality);
  }

  @Override
  public Speciality findById(Long aLong) {
    return specialityRepository.findById(aLong).orElse(null);
  }

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialities = new HashSet<>();
    specialityRepository.findAll().iterator().forEachRemaining(specialities::add);
    return specialities;
  }

  @Override
  public void deleteById(Long aLong) {
    specialityRepository.deleteById(aLong);
  }

  @Override
  public void delete(Speciality object) {
    specialityRepository.delete(object);
  }
}
