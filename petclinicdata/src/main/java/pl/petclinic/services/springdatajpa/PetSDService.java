package pl.petclinic.services.springdatajpa;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Pet;
import pl.petclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class PetSDService implements pl.petclinic.services.PetService {
    private final PetRepository petRepository;

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
