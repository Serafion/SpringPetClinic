package pl.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Owner;
import pl.petclinic.repositories.OwnerRepository;
import pl.petclinic.repositories.PetRepository;
import pl.petclinic.repositories.PetTypeRepository;
import pl.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpa implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpa(OwnerRepository ownerRepository,
                      PetRepository petRepository,
                      PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> owner = ownerRepository.findById(aLong);
        return owner.isPresent() ? owner.get() : null;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
