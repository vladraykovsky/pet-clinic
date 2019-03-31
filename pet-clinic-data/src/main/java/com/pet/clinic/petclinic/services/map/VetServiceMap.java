package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.model.Vet;
import com.pet.clinic.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService <Vet, Long>  implements VetService {

  @Override
  public Vet findByLastName(String lastName) {
    return null;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet vet) {
    return super.save( vet);
  }
}
