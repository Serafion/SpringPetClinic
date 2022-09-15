package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
