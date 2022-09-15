package pl.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.petclinic.model.Specialty;
import pl.petclinic.services.SpecialtiesService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialtyMapService extends AbstractMapService<Specialty,Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
