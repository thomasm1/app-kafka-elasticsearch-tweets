package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "NFTADDRESS") /// ANGULAR's NFT.ts
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAddress  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	private String address;  // VARCHAR(2550

	@Column(name = "native_token") // NUMBER (10,6)
	private Float nativeToken;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nftAddress")
	@Column(name = "tokens")
	private List<RawToken> rawTokens;  //  "123.123456 BUSD  	// token name, token amount	@OneToOne

// USING UNI-DIRECTIONAL, B/C BI-DIRECTION NEEDED CURRENTLY
//	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "nftAddress" )
//	@Column(name = "nft")
//	private List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}
