package com.pet.clinic.petclinic.repositories;

import com.pet.clinic.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository  extends JpaRepository<PetType, Long> {
  PetType findByName(String lastName);
}
