package app.mapl.repositories;

import app.mapl.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Override
    UserProfile save(UserProfile entity);
}