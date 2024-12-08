package app.mapl.repositories;

import app.mapl.models.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="metadata", path = "metadata")
public interface MetadataRepository extends JpaRepository<Metadata, Integer>, JpaSpecificationExecutor<Metadata> {
}