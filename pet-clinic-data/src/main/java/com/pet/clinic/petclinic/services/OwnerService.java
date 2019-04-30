package com.pet.clinic.petclinic.services;

import com.pet.clinic.petclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

  List<Owner> findAllByLastNameLike(String lastName);

}
