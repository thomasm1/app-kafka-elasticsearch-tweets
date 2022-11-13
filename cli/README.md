CliApplication => ServletInitializer()

CliApplication => 
    View() => 
        [singleton]Controller() => 
            [singleton]Manager()  => 
                DaoImpl => DataStore

CliApplication =>
    MainDashboard.mainUser(args) => [[VARS: DRIVER, SRC_DATA_STARTUP_TEXT_TXT]]

CliLogger => [Singleton Logger Log4j]
* As a customer, I can view the nfts on the lot. 
* As a customer, I can make an offer for a nft. 
* As a customer, I am alerted if offer APPROVED/DECLINED
* As a customer, I can view the nfts that I own. 
* As a customer, I can view my remaining payments for a nft(s) I own.