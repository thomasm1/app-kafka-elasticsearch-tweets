package app.mapl.repositories;

import app.mapl.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="offers", path="offers")
public interface OffersRepository extends JpaRepository<Offer, Integer> {
}
