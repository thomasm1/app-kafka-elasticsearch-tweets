package app.mapl.repositories;

import app.mapl.models.NftRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel="nft_ref", path = "nft_ref")
public interface NftRefRepository extends JpaRepository<NftRef, Integer> {
    NftRef findByName(@RequestParam String name);


}
