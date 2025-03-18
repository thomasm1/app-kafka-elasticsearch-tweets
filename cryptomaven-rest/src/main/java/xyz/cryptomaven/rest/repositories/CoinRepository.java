package xyz.cryptomaven.rest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.cryptomaven.rest.models.Coin;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

  @Override
  List<Coin> findAll();
  // JPQL  ///////////////////
//  @Query("SELECT c FROM Coin c WHERE UPPER(c.tokens) LIKE UPPER(CONCAT('%', :tokens, '%')) OR UPPER(c.nativeToken) LIKE UPPER(CONCAT('%', :nativeOrTokens, '%'))")
//  Page<Coin> search(@Param("nativeOrTokens") String nameOrSymbol, Pageable pageable);


}
