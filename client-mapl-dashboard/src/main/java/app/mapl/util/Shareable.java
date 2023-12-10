package app.mapl.util;

import java.io.Serializable;

public interface Shareable extends Serializable {

    String getItemData();

    boolean isWeb3Link();
}
