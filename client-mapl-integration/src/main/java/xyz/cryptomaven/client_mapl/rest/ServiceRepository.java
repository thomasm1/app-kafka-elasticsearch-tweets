package xyz.cryptomaven.client_mapl.rest;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    @NotNull
    Optional<Service> findById(UUID id);
}
