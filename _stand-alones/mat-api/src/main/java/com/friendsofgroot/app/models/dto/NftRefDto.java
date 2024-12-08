package com.friendsofgroot.app.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.friendsofgroot.app.models.NftRef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A Dto for the {@link NftRef} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NftRefDto implements Serializable {
    private static long serialVersionUID = 1L;
    private String name;
    private String owner;
    private String email;
    private String address;
    private String chain;
//    private NftDto  nft;
}
