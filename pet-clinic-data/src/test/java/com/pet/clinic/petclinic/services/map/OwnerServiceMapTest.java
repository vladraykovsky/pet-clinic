package com.pet.clinic.petclinic.services.map;

import com.pet.clinic.petclinic.model.Owner;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

  OwnerServiceMap ownerServiceMap;

  @BeforeEach
  public void setUp() {
      ownerServiceMap = new OwnerServiceMap();
      ownerServiceMap.save(Owner.builder().firstName("Vlad").id(42L).build());
      ownerServiceMap.save(Owner.builder().firstName("Vladik").build());
  }

  @Test
  void findByLastName() {
    Owner owner = Owner.builder().firstName("Yura").build();
    ownerServiceMap.save(owner);
    assertEquals(owner, ownerServiceMap.findByLastName("Yura"));
  }

  @Test
  void findAll() {
    assertEquals(ownerServiceMap.findAll().size(), 2);
  }

  @Test
  void delete() {
    Owner owner = Owner.builder().id(1L).build();
    ownerServiceMap.save(owner);
    ownerServiceMap.delete(owner);
    assertEquals(ownerServiceMap.findAll().size(), 2);
  }

  @Test
  void deleteById() {
    Owner owner = Owner.builder().id(1L).build();
    ownerServiceMap.save(owner);
    ownerServiceMap.deleteById(1L);
    assertEquals(ownerServiceMap.findAll().size(), 2);
  }

  @Test
  void findById() {
    Owner owner = ownerServiceMap.findById(42L);
    assertEquals(owner.getId(), new Long(42L) );
  }

  @Test
  void save() {
    Owner owner = Owner.builder().id(1L).build();
    ownerServiceMap.save(owner);
    assertEquals(ownerServiceMap.findById(1L), owner);
  }
}
