package app.mapl.repositories;

import app.mapl.models.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="attribute", path = "attribute")
public interface AttributeRepository extends JpaRepository<Attribute, Integer>, JpaSpecificationExecutor<Attribute> {
}