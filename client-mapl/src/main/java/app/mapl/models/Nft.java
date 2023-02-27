package app.mapl.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "NFT")
public class Nft {

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
