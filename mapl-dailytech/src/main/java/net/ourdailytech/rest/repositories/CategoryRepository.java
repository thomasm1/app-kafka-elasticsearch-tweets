package net.ourdailytech.rest.repositories;

import net.ourdailytech.rest.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
