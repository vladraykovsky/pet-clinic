package com.pet.clinic.petclinic.bootstrap;

import com.pet.clinic.petclinic.model.*;
import com.pet.clinic.petclinic.services.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@AllArgsConstructor
@Component
public class DataLoader  implements CommandLineRunner {

  private final OwnerService ownerServiceMap;
  private final VetService vetServiceMap;
  private final PetTypeService petTypeService;
  private final PetService petService;
  private final VisitService visitService;

  @Override
  public void run(String... args) throws Exception {
    Owner owner  = new Owner();
    owner.setFirstName("FIRST OWNER");
    owner.setLastName("FIRST");

    Owner owner2  = new Owner();
    owner2.setFirstName("second");
    owner2.setLastName("last");

    Owner owner3  = new Owner();
    owner3.setFirstName("second");
    owner3.setLastName("last");

    Owner savedOwner = ownerServiceMap.save(owner);
    ownerServiceMap.save(owner2);
    ownerServiceMap.save(owner3);
    Vet vet = new Vet();
    vet.setFirstName("fist name");
    vet.setLastName("last name");

    Vet vet2 = new Vet();
    vet2.setFirstName("fist name");
    vet2.setLastName("last name");

    Vet vet3 = new Vet();
    vet3.setFirstName("Third");
    vet3.setLastName("Third");

    Vet savedVet = vetServiceMap.save(vet);
    Vet savedVet2 = vetServiceMap.save(vet2);

    Vet savedVet3 =  vetServiceMap.save(vet3);

    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petTypeCat = new PetType();
    petTypeCat.setName("Cat");
    PetType dog = petTypeService.save(petType);
    PetType cat = petTypeService.save(petTypeCat);

    Pet pet = new Pet();
    pet.setName("Fido");
    pet.setBirthDate(LocalDate.now());
    pet.setOwner(savedOwner);
    pet.setPetType(dog);

    Pet fido  = petService.save(pet);

    Visit visit = new Visit();
    visit.setDescription("some description");
    visit.setDate(LocalDate.now());
    visit.setPet(fido);

    Visit firstVisit = visitService.save(visit);

    savedOwner.setPets(new HashSet<Pet>() {{add(fido); }});

    ownerServiceMap.save(savedOwner);


  }
}
