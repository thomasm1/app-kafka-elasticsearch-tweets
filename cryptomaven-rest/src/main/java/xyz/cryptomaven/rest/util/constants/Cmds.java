package xyz.cryptomaven.rest.util.constants;

public class Cmds {
    public static final String WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL = "Welcome to My Personal Librarian, my name is MaPL.";
    public static final String LOGGING_AT = "... from Logger Instance! TS::";
     //menu dashboard
    public static final String WHAT_TO_DO = "What would you like to do?  ";
    public static final String VIEW_MY_COINS = "View my coin tokens " +
            "";
    public static final String VIEW_ALL_COINS = "View all coin tokens";
    public static final String  VIEW_COIN_DETAILS = "View a coin token in detail";
    public static final String MAKE_AN_OFFER = "Find one you like? Make an offer!";
    public static final String MAKE_INQUIRY_MY_OFFERS = "Inquire about my existing offers";
    public static final String PRESS_DIGIT = "\n There they are!, to make an offer, press ";
    public static final String HOW_MANY_MONTHS = "and how many months to pay remainder?";

    // ADMIN
    public static final String ADMIN_PERKS = "What is next, Valued one? \n... Shall I order you a pizza for a late lunch?... \n";

    // GREETINGS
    public static final String WELCOME_REGISTER = "Welcome to Registration, ";
    public static final String LEAVE_MENU = "To leave, press 0";
    public static final String GOOD_BYE = "So sorry to see you leave! Please come back soon!!\n";

// REGISTER
    public static final String REGISTER_UNAME = "Please type your username below:\n";
    public static final String REGISTER_PW = "Now, please type an alpha-numeric password:\n";
    public static final String REGISTER_FNAME = " first name:\n";
    public static final String REGISTER_LNAME = " ,  last name:\n";

// EDIT PROFILE
    public static final String EDIT_MY_PROFILE = "Edit my Profile";
    public static final String WELCOME_PROFILE = "Welcome to Your Profile, \n";
    public static final String EDIT_PW  = "Edit password :";
    public static final String EDIT_FNAME = "Edit first name :";
    public static final String EDIT_LNAME = "Edit your last name  :";

    public static final String EDIT_USERTYPE = "Edit your Usertype :";
    public static final String EDIT_GROUP = "Edit your group :";
    public static final String EDIT_EMAIL = "Edit your email :";
    public static final String EDIT_PHONE = "Edit your phone number :";
    public static final String EDIT_URL = "Edit your image URL :";

    // Errors

    public static final String OOPS  = "Oops,  ";
    public static final String OOPS_OPTIONS = "OOPS! options are between 0 and 6 : = ";
    public static final String OOPS_JDBC = "oops, Driver not found :-O. Hey! Check Build Path for the Oracle Java Database Connector Class! Put the ODBC Jar into Build Path";
    public static final String OOPS_TRY_AGAIN = "Oops, something went wrong, try again please\n";

    // titles
    public static final String COINMARKET_TITLE = "I-*heart*- ETH   tokens: Market view...";

    // DIGITS
    public static final String ZERO = "0.) ";
    public static final String ONE = "1.) ";
    public static final String TWO = "2.) ";
    public static final String THREE = "3.) ";
    public static final String FOUR = "4.) ";
    public static final String FIVE = "5.) ";
    public static final String SIX = "6.) ";
    public static final String SEVEN = "7.) ";

    // behavior
    public static final String BR = "\n";

    // comments
    public static final String NICE = " Nice! ";
    public static final String NOW_LOGGING = "|||_______...Logging__________|||";

    private final String cmd;
    public String getCmds() {
        return cmd;
    }

    Cmds(String cmd) {
        this.cmd = cmd;
    }



}
