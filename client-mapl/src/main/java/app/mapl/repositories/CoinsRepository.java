package app.mapl.repositories;

import app.mapl.models.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( collectionResourceRel = "coin", path = "coins")
public interface CoinsRepository extends JpaRepository<Coin, Integer> {
//    Object findByUsername(String username); // logic needed

        Page<Coin> findAllByCoinTokenIsLikeIgnoreCase(String coinToken, Pageable pageable);

        Page<Coin> findAllByCoinSymbol(String coinSymbol, Pageable pageable);

        Page<Coin> findAllByCoinTokenIsLikeIgnoreCaseAndCoinSymbol(String coinToken, Coin coinSymbol, Pageable pageable);


}