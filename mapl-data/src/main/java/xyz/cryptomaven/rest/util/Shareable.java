package xyz.cryptomaven.rest.util;

import java.io.Serializable;

public interface Shareable extends Serializable {

    String getItemData();

    boolean isWeb3Link();
}
