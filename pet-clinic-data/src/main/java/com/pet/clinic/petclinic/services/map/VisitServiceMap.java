package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Visit;
import com.pet.clinic.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {


  @Override
  public Visit findByLastName(String lastName) {
    return null;
  }

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Visit save(Visit visit) {
    if(visit.getPet() == null || visit.getPet().getPetType() == null || visit.getId() == null) {
      throw  new RuntimeException("invalid visit");
    }
    return super.save(visit);
  }
}
