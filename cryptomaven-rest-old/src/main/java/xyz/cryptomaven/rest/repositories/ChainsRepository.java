package xyz.cryptomaven.rest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.cryptomaven.rest.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ChainsRepository extends JpaRepository<Chain, Long> {
    Optional<Chain> findByName(String name);
  @Override
  List<Chain> findAll();
  // JPQL  ///////////////////
  @Query("SELECT c FROM Chain c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :nameOrSymbol, '%')) OR UPPER(c.symbol) LIKE UPPER(CONCAT('%', :nameOrSymbol, '%'))")
  Page<Chain> search(@Param("nameOrSymbol") String nameOrSymbol, Pageable pageable);


}
