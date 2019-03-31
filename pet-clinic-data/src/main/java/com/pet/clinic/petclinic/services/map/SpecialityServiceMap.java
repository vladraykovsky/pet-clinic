package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Speciality;
import com.pet.clinic.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

  @Override
  public Speciality findByLastName(String lastName) {
    return null;
  }

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Speciality object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Speciality save(Speciality speciality) {
    return super.save(speciality);
  }
}
