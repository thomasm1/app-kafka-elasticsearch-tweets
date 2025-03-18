package xyz.cryptomaven.rest.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
public class UserCoin  extends AbstractDomainClass {

  private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nft_id")
    private Coin coin;





}
