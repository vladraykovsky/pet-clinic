package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.repositories.OwnerRepository;
import com.pet.clinic.petclinic.repositories.PetRepository;
import com.pet.clinic.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

  @Mock
  OwnerRepository ownerRepository;

  @Mock
  PetRepository petRepository;

  @Mock
  PetTypeRepository petTypeRepository;

  @InjectMocks
  OwnerServiceJpa ownerServiceJpa;

  Owner returnOwner;

  @BeforeEach
  public void setUp() {
    returnOwner = Owner.builder().lastName("Vlad").id(1L).build();
  }

  @Test
  void findByLastName() {
    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
    Owner ownerService = ownerServiceJpa.findByLastName("Vlad");
    assertEquals("Vlad", ownerService.getLastName());
    verify(ownerRepository, times(1) ).findByLastName(any());
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().firstName("Vladik").build();
    when(ownerRepository.save(any())).thenReturn(ownerToSave);
    assertEquals(ownerServiceJpa.save(ownerToSave), ownerToSave);
    verify(ownerRepository, times(1)).save(any());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
    assertEquals(ownerServiceJpa.findById(1L), returnOwner );
    verify(ownerRepository, times(1)).findById(any());
  }

  @Test
  void findAll() {
    Owner ownerToSave = Owner.builder().firstName("Vlad").build();
    Owner ownerToSave2 = Owner.builder().firstName("Vladik").build();
    List<Owner> list = new ArrayList<Owner>() {{
      add(ownerToSave);
      add(ownerToSave2);
    }};

    when(ownerRepository.findAll()).thenReturn(list);
    assertEquals( 2, ownerServiceJpa.findAll().size());
    verify(ownerRepository, times(1) ).findAll();
  }

  @Test
  void deleteById() {
    ownerServiceJpa.deleteById(1L);
    verify(ownerRepository, times(1)).deleteById(anyLong());
  }

  @Test
  void delete() {
    ownerServiceJpa.delete(returnOwner);
    verify(ownerRepository, times(1)).delete(any());
  }
}
