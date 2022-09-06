package pl.petclinic.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.petclinic.model.*;
import pl.petclinic.services.*;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");

        Specialty savedRadiology = specialtiesService.save(radiology);
        Specialty savedSurgery = specialtiesService.save(surgery);
        Specialty savedDentistry = specialtiesService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Pawel");
        owner1.setLastName("Papadopulos");
        owner1.setAdress("Papadopolusowa");
        owner1.setCity("Atlanta");
        owner1.setTelephone("12345678");

        Pet mikesPet = new Pet();
        mikesPet.setName("Klara");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.setPets(Set.of(mikesPet));

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marek");
        owner2.setLastName("Papadopulos");
        owner2.setAdress("Krzakowa");
        owner2.setCity("Boston");
        owner2.setTelephone("98756438");

        Pet blakePet = new Pet();
        blakePet.setName("Barbara");
        blakePet.setPetType(savedCatPetType);
        blakePet.setOwner(owner2);
        blakePet.setBirthDate(LocalDate.now());
        owner2.setPets(Set.of(blakePet));

        ownerService.save(owner2);

        System.out.println("Loaded owners");


        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Nowak");
        vet1.setSpecialties(Set.of(savedRadiology, savedDentistry));

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Natalia");
        vet2.setLastName("Paparapa");
        vet2.setSpecialties(Set.of(savedSurgery));

        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}
