package app.mapl.repositories;

import app.mapl.models.auth.CredentialEntity;
import app.mapl.models.auth.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository {
    CredentialEntity save(CredentialEntity entity);
    Optional<CredentialEntity> getCredentialsByUserId(Long userId);

    Optional<CredentialEntity> findByUser(User userEntity);
}
