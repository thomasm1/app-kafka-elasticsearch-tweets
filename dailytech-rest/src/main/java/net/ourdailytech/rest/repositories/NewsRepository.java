package net.ourdailytech.rest.repositories;

import net.ourdailytech.rest.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
