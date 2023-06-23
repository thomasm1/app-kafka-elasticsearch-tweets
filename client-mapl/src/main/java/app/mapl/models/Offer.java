package app.mapl.models;

import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "offers")
public class Offer {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offerid", nullable = false)
	int offerID;
//	int userID;

	@Column(name = "username")
	String username;
	@Column(name = "coinid")
	int coinId;
	@Column(name = "offeramt")
	double offerAmt;
	@Column(name = "offermos")
	int offerMos;
	@Column(name = "offerstatus")
	@Size(min=2, message="Enter at least 2 characters")
	String offerStatus; // PENDING, APPROVED, REJECTED;
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Offer(String username, int coinId, double offerAmt, int offerMos, String offerStatus) {
		this.username = username;
		this.coinId = coinId;
		this.offerAmt = offerAmt;
		this.offerMos = offerMos;
		this.offerStatus = offerStatus;
	}


	public String getUsername() {
		return username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Offer offer = (Offer) o;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
