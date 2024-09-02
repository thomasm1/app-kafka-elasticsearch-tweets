package app.mapl.repositories;

import app.mapl.models.Nft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftRepository extends JpaRepository<Nft, Integer> {
}