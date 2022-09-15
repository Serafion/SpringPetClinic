package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
