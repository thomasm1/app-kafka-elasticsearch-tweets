package app.mapl.repositories;

import app.mapl.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="offer", path="offer")
public interface OffersRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findAllByUsername(String uname);
}
