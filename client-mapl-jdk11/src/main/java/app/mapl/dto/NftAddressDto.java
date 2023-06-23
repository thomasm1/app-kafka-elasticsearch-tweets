package app.mapl.dto;

import app.mapl.models.NftAddress;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * A DTO for the {@link NftAddress} entity
 */
@Data
public class NftAddressDto implements Serializable {
    private  int id;
    private  String address;
    private  Double nativeToken;
//    @JsonProperty("tokens")
    private  HashMap<String, Double> tokens;
    private  List<NftDto> nfts;
}