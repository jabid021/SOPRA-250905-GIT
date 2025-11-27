package quest.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import quest.model.Matiere;

@ApplicationScoped
public class MatiereRepository implements PanacheRepositoryBase<Matiere, Integer> {

}
