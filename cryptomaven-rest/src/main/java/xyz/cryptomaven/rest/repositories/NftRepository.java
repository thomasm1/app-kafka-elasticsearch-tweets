package xyz.cryptomaven.rest.repositories;

import xyz.cryptomaven.rest.models.NftCoin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NftRepository extends JpaRepository<NftCoin, Long> {

  List<NftCoin> findAllByName(String name);
}
