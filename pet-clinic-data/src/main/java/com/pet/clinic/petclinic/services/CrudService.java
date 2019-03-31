package com.pet.clinic.petclinic.services;


import java.util.Set;

public interface CrudService<T, ID> {

  T findByLastName(String lastName);

  T save(T t);

  T findById(ID id);

  Set<T> findAll();

  void deleteById(ID id);

  void delete(T object);

}
