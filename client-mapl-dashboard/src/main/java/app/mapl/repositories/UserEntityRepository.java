package app.mapl.repositories;

import app.mapl.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity entity);

    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findUserEntityByUserId(String userId);

}