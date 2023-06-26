package app.mapl.repositories;

import app.mapl.models.OfferLogic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="offerlogic", path="offerlogic")
public interface OfferLogicRepository extends JpaRepository<OfferLogic, Integer> {
}
