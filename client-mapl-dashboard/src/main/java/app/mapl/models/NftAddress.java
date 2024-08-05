package app.mapl.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Data
@Entity
@Table(name = "NFT_ADDRESS") /// ANGULAR's NFT.ts
public class NftAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	int id;

	 String address;

	@Column(name="native")
	Double nativeToken;

	@Transient
	HashMap<String, Double> tokens; // token name, token amount	@OneToOne
	@OneToMany
	@Column(name = "nft_address_id")
	List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}
