package app.mapl.repositories;

import app.mapl.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel="weblink", path="weblink")
public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}