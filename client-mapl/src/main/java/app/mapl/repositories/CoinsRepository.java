package app.mapl.repositories;

import app.mapl.models.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsRepository extends JpaRepository<Coin, Integer> {
//    Object findByUsername(String username); // logic needed

        Page<Coin> findAllByCoinTokenIsLikeIgnoreCase(String coinToken, Pageable pageable);

        Page<Coin> findAllByCoinSymbol(String coinSymbol, Pageable pageable);

        Page<Coin> findAllByCoinTokenIsLikeIgnoreCaseAndCoinSymbol(String coinToken, Coin coinSymbol, Pageable pageable);


}