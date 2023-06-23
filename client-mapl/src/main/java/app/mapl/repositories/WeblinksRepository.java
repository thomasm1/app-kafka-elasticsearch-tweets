package app.mapl.repositories;

import app.mapl.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}