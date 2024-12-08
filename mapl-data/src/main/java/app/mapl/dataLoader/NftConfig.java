package app.mapl.dataLoader;

import app.mapl.models.Attribute;
import app.mapl.models.Metadata;
import app.mapl.models.Nft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NftConfig {

    private static final Logger log = LoggerFactory.getLogger(NftConfig.class);
    @Bean
    public Attribute newAttribute() {
        String value = "_new_value_";
        String trait_type = "new_trait_type";

        return new Attribute(0, value, trait_type, null);
    }

    @Bean
    public Metadata newMetadata() {
        String name = "_new_metadata_";
        String description = "_new_desc_";
        String image = "https://s3.amazonaws.com/tmm.net/img/ether.png";

                            // metadataId, name, description, image, nft, attributes[]
        return new Metadata(0,name,description,image,null,null);
    }

    @Bean
    public Nft newNft() {
        String name = "_new_nft_";
        double amount = 123;
                        // id, name, amount, metadata_id, nftAddress)
        return new Nft(0,name, amount,null,null);
    }


}
