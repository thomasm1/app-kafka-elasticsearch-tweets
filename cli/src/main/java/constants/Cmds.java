package constants;

public enum Cmds {

    
    //menu dashboard
    WHAT_TO_DO("What would you like to do? \n "),
    VIEW_MY_CARS("View my cars\n "),
    VIEW_ALL_CARS("View all cars\n"),
    VIEW_CAR_DETAILS("View a car in detail\n"),
    MAKE_AN_OFFER("Find one you like? Make an offer!\n"),
    MAKE_INQUIRY_MY_OFFERS("Inquire about my existing offers\n"),
    PRESS_DIGIT("\n There they are!, to make an offer, press "),
    HOW_MANY_MONTHS("and how many months to pay remainder?"),
    
    // GREETINGS 

    WELCOME_REGISTER("Welcome to Registration, "), 
    LEAVE_MENU("To leave, press 0"), 
    GOOD_BYE("So sorry to see you leave! Please come back soon!!\n"),

// REGISTER

    REGISTER_UNAME("Please type your username below:\n"), 
    REGISTER_PW("Now, please type an alpha-numeric password:\n"),
    REGISTER_FNAME(" first name:\n"), 
    REGISTER_LNAME(" ,  last name:\n"),

// EDIT PROFILE
    WELCOME_PROFILE("Welcome to Your Profile, "),
    EDIT_PW ("Edit your password? :\n"),
    EDIT_FNAME(" first name? :\n"),
    EDIT_LNAME(" ,  edit your last name?  :\n"),
    EDIT_GENDER(" ,  edit your group? :\n"),
    EDIT_EMAIL(" ,  edit your email? :\n"),
    EDIT_PHONE(" ,  edit your phone number? :\n"),
    EDIT_URL(" ,  edit your image URL? :\n"),

    // Errors

    OOPS ("Oops,  "),
    OOPS_OPTIONS("OOPS! options are between 0 and 6 :("),
    OOPS_JDBC("oops, Driver not found :-O. Hey! Check Build Path for the Oracle Java Database Connector Class! Put the ODBC Jar into Build Path"),
    
    // titles
    CARLOT_TITLE("I-*heart*-electric cars: CarLot view..."),
    
    
    // DIGITS
    ZERO("0.) "),
    ONE("1.) "),
    TWO("2.) "),
    THREE("3.) "),
    FOUR("4.) "),
    FIVE("5.) "),
    SIX("6.) "),
    SEVEN("7.) "),
    
    // behavior
    BR("\n"),
    
    // comments
    NICE(" Nice! ");

    private final String cmd;
    public String getCmds() {
        return cmd;
    }

    Cmds(String cmd) {
        this.cmd = cmd;
    }

    
 
}
