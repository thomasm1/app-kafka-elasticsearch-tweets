package app.mapl.models.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link app.mapl.models.Coin} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoinDto implements Serializable {
    static long serialVersionUID = 1L;

    private   int coinId;
    private   String coinToken;
    private   String coinSymbol;
    private   double priceTotal;
    private   int purchased;


}