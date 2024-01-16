package app.mapl.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cointable")
public class Coin implements Serializable {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coinid", nullable = false)
	int coinId;
	@Column(name = "cointoken")
	String coinToken;
	@Column(name = "coinsymbol")
	String coinSymbol;
	@Column(name = "pricetotal")
	double priceTotal;
	@Column(name = "amounttotal")
	double amountTotal;

	int purchased;


	public int isPurchased() {
		return 0;
	}
	/*
	 * Java Object representation of a table in DB.
	 * Tables: User, Payments, Offers,
	 * *purchased = 1 ; (not) purchased = 0
	 */

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Coin coin = (Coin) o;
		return false;
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
