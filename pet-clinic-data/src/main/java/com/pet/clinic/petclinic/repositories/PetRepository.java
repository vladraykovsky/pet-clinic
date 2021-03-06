package com.pet.clinic.petclinic.repositories;

import com.pet.clinic.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

  Pet findByName(String lastName);
}
