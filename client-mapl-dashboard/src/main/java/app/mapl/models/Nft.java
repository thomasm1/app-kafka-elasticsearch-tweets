package app.mapl.models;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "NFT")
public class Nft {
	public Nft() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String name;
	int amount;
	@OneToOne
	@JoinColumn(name = "metadata_metaid")
	Metadata metadata;
	int nft_address_id;



}
