CliApplication => ServletInitializer()

CliApplication => View() => [singleton]Controller() => [singleton]Manager()  => DaoImpl => DataStore

CliApplication => SystemUser.UserMain() => 
//OK		* As a customer, I can view the cars on the lot. (1/2)
//OK		* As a customer, I can make an offer for a car. (1/2)
//OK		* As a customer, I can view the cars that I own. 
//OK		* As a customer, I can view my remaining payments for a car.