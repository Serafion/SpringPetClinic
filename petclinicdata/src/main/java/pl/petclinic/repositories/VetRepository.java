package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
