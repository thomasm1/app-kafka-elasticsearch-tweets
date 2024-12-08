package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Nft;
import com.friendsofgroot.app.models.User;

public class UserNftbuy {
    private User user;
    private Nft nft;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Nft getNft() {
        return nft;
    }
    public void setNft(Nft nft) {
        this.nft = nft;
    }


}
