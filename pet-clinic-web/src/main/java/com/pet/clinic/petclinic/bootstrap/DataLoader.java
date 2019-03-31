package com.pet.clinic.petclinic.bootstrap;

import com.pet.clinic.petclinic.model.Owner;
import com.pet.clinic.petclinic.model.Vet;
import com.pet.clinic.petclinic.services.OwnerService;
import com.pet.clinic.petclinic.services.PetTypeService;
import com.pet.clinic.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader  implements CommandLineRunner {

  private final OwnerService ownerServiceMap;
  private final VetService vetServiceMap;
  private final PetTypeService petTypeService;

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

    ownerServiceMap.save(owner);
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

    vetServiceMap.save(vet);
    vetServiceMap.save(vet2);

    vetServiceMap.save(vet3);
  }
}
