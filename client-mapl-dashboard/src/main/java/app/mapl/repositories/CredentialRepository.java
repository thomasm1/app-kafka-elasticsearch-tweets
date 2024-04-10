package app.mapl.repositories;

import app.mapl.models.CredentialEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository {
    CredentialEntity save(CredentialEntity entity);
    Optional<CredentialEntity> getCredentialsByUserEntityId(Long userId);
}
