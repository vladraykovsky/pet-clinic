package com.pet.clinic.petclinic.repositories;

import com.pet.clinic.petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

  Vet findByLastName(String lastName);
}
