package xyz.cryptomaven.rest.util.dataLoader;


import org.springframework.context.annotation.Profile;
import xyz.cryptomaven.rest.models.Attribute;
import xyz.cryptomaven.rest.models.NftCoin;
import xyz.cryptomaven.rest.models.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Profile("test")
@Configuration
public class NftConfig {

    private static final Logger log = LoggerFactory.getLogger(NftConfig.class);
    @Bean
    public Attribute newAttribute() {
        String attribute_value = "_new_value_";
        String trait_type = "new_trait_type";

        return new Attribute(0L, attribute_value, trait_type, null );
    }

    @Bean
    public Metadata newMetadata() {
        String name = "_new_metadata_";
        String description = "_new_desc_";
        String image = "https://s3.amazonaws.com/tmm.net/images/crypto/ether.png";
      List<Attribute> attributes= new ArrayList<>();
                            // metadataId, name, description, image, nft, attributes[]

        return   Metadata.builder().id(0L).name(name).description(description).image(image).attributes(attributes).build();
    }
    @Bean
      public NftCoin newNft() {
        String  name2 = "_new_nft_";
        double amount = 123;
                        // id, name, amount, metadata_id, nftAddress)
          return NftCoin.builder().id(0L).name(name2).amount(amount).metadata(null).coin(null).build().getMetadata().getNftCoin();

            }


}
