package pl.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
