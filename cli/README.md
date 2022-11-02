CliApplication => ServletInitializer()

CliApplication => 
    View() => 
        [singleton]Controller() => 
            [singleton]Manager()  => 
                DaoImpl => DataStore

CliApplication =>
    MainDashboard.mainUser(args) => [[VARS: DRIVER, SRC_DATA_STARTUP_TEXT_TXT]]

CliLogger => [Singleton Logger Log4j]
* As a customer, I can view the cars on the lot. 
* As a customer, I can make an offer for a car. 
* As a customer, I am alerted if offer APPROVED/DECLINED
* As a customer, I can view the cars that I own. 
* As a customer, I can view my remaining payments for a car(s) I own.