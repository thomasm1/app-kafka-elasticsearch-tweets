package app.mapl.repositories;

import app.mapl.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}