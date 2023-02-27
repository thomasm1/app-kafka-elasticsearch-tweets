package app.mapl.models;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cointable")
public class Coin implements Serializable {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coinid", nullable = false)
	int coinId;
	@Column(name = "cointoken")
	String coinToken;
	@Column(name = "coinsymbol")
	String coinSymbol;
	@Column(name = "pricetotal")
	double priceTotal;

	int purchased;

	public int isPurchased() {
		return 0;
	}
	/*
	 * Java Object representation of a table in DB.
	 * Tables: User, Payments, Offers,
	 * *purchased = 1 ; (not) purchased = 0
	 */

}
