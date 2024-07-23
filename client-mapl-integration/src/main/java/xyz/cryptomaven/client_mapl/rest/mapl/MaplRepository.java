package xyz.cryptomaven.client_mapl.rest.mapl;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaplRepository extends JpaRepository <MaplTopic,UUID> {

    Optional<MaplTopic> getMaplTopic(UUID id);

}
