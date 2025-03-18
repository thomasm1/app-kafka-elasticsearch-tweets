package xyz.cryptomaven.rest.repositories;

import xyz.cryptomaven.rest.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}
