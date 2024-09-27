package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.NftAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="nftaddress", path = "nftaddress")
public interface NftAddressRepository extends JpaRepository<NftAddress, Integer>, JpaSpecificationExecutor<NftAddress> {
}
