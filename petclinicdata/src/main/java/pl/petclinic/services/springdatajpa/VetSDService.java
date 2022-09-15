package pl.petclinic.services.springdatajpa;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Vet;
import pl.petclinic.repositories.VetRepository;
import pl.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class VetSDService implements VetService {

    private VetRepository vetRepository;
    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
