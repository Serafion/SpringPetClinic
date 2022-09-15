package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
