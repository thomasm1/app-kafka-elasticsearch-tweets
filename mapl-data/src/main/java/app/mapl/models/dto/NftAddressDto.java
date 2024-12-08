package app.mapl.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Dto for {@link app.mapl.models.NftAddress}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAddressDto implements Serializable {
    private int id;
    private Integer version;
    private Date dateCreated;
    private Date lastUpdated;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String address;
    private Float nativeToken;
    private List<RawTokenDto> rawTokens;
    private List<NftDto> nfts;
}
