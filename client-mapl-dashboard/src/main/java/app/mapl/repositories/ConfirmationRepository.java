package app.mapl.repositories;

import app.mapl.models.ConfirmationEntity;
import app.mapl.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="confirmation", path="confirmation")
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
    @Override
    ConfirmationEntity save(ConfirmationEntity entity);
    Optional<ConfirmationEntity> findByKey(String key);
    Optional<ConfirmationEntity> findByUserEntity(UserEntity userEntity);

}