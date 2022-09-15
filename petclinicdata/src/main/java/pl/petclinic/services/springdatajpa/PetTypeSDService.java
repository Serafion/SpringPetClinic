package pl.petclinic.services.springdatajpa;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.PetType;
import pl.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class PetTypeSDService implements pl.petclinic.services.PetTypeService {
    private PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
