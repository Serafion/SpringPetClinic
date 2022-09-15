package pl.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Pet;
import pl.petclinic.services.PetService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        super.save(object);
        return object;
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
