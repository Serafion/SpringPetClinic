package pl.petclinic.services.springdatajpa;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Specialty;
import pl.petclinic.repositories.SpecialtyRepository;
import pl.petclinic.services.SpecialtiesService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@AllArgsConstructor
public class SpecialtySDService implements SpecialtiesService {
    private final SpecialtyRepository specialtyRepository;

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
