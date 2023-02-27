package app.mapl.dto;

import app.mapl.models.NftAddress;
import app.mapl.models.User;
import lombok.Data;

import java.io.Serializable;


@Data
public class AddressDto  implements Serializable {
    private int id;

    private String description;

    private String owner;

    private String address;

    private String chain;


    private String iconUrl;

    private String blockExplorerUrl;

    private User user;

    private int chainId;

    private NftAddress nftAddress;

    public NftAddress getNftAddress() {
        return nftAddress;
    }
}
