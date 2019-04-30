package com.pet.clinic.petclinic.repositories;

import com.pet.clinic.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);
}
