package com.pet.clinic.petclinic.services.jpa;

import com.pet.clinic.petclinic.model.Pet;
import com.pet.clinic.petclinic.repositories.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;




@ExtendWith(MockitoExtension.class)
class PetServiceJpaServiceTest {


  @InjectMocks
  PetServiceJpaService petServiceJpaService;

  @Mock
  PetRepository petRepository;;


  @Test
  public void findByNameTest() {
    Pet pet = new Pet();
    pet.setName("firstName");
    Mockito.when(petRepository.findByName(Mockito.anyString()))
        .thenReturn(pet);
    Pet name = petServiceJpaService.findByLastName("firstName");
    Assertions.assertEquals(pet.getName(),name.getName());
  }


}
