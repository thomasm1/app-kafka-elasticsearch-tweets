package app.mapl.service;


import app.mapl.dataLoader.BookmarkManager;
import app.mapl.models.Coin;
import app.mapl.models.User;

import java.util.List;


// Like Singleton Managers, This Service is a Controllers return singletons


public class CoinLocalService {

    private static CoinLocalService instance = new CoinLocalService();
    private CoinLocalService() {}
    public static CoinLocalService getInstance() {
        return instance;
    }

    public void saveLocalUserCoin(User user, Coin bookmark) {
        BookmarkManager.UserManager.getInstance().saveLocalUserCoin(user, bookmark);
    }
    public List<Coin> getLocalUserCoinsByUser(User user) {
        List<Coin> coinList = BookmarkManager.UserManager.getInstance().getLocalUserCoinsByUser(user);
        System.out.println(coinList);
        return coinList;
    }

}
