package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Nft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="nft", path = "nft")
public interface NftRepository extends JpaRepository<Nft, Integer> {
}