

```agsl
CliApplication => ServletInitializer()

CliApplication => 
    View() => 
        [singleton]Controller() => 
            [singleton]Manager()  => 
                DaoImpl => DataStore

CliApplication =>
    Ma
```

inDashboard.mainUser(args) => [[VARS: DRIVER, SRC_DATA_STARTUP_TEXT_TXT]]

MAIN MENU -> A. Admin, B. User
1.) Log in \n
+ 2.) Register  \n
+ 3.) Browse the lot from Oracle Database\n
+ 4.) Load Test Data =  cliDataLoader(); \n
+ 5.) Play Navigation Game [Offline] \n
+ 6.) Download from Web \n
+  7+) Set in Motion Automated USER [Offline]\n
+ Stop Application, press '0'.\n);


ADMIN_MENU 
* 1 + View Financials and Payments\n
* 2 + View Car Lot\n
* 3+Add Car\n
* 4 +Remove Unpurchased Car\n
* 5 + View and/or Accept Offers\n
* 6 + get Users With Cars\n
* 7 + .) open MaPL Control(); \n
* 0 + Logout);

USER_MENU
* (1: +VIEW_MY_CARS);
* (2: +VIEW_ALL_CARS);
* (3: +VIEW_CAR_DETAILS);
* (4: +MAKE_AN_OFFER);
* (5: +MAKE_INQUIRY_MY_OFFERS);
* (6: +EDIT_MY_PROFILE);
* (0: +LEAVE_MENU);




CliLogger => [Singleton Logger Log4j]
* As a customer, I can view the nfts on the lot. 
* As a customer, I can make an offer for a nft. 
* As a customer, I am alerted if offer APPROVED/DECLINED
* As a customer, I can view the nfts that I own. 
* As a customer, I can view my remaining payments for a nft(s) I own.