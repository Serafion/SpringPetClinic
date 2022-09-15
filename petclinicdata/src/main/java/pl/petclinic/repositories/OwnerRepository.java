package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
}
