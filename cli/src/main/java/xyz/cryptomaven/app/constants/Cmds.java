package xyz.cryptomaven.app.constants;

public class Cmds {

    
    //menu dashboard
    public static final String WHAT_TO_DO = "What would you like to do? \n ";
    public static final String VIEW_MY_CARS = "View my cars\n ";
    public static final String VIEW_ALL_CARS = "View all cars\n";
    public static final String  VIEW_CAR_DETAILS = "View a car in detail\n";
    public static final String MAKE_AN_OFFER = "Find one you like? Make an offer!\n";
    public static final String MAKE_INQUIRY_MY_OFFERS = "Inquire about my existing offers\n";
    public static final String PRESS_DIGIT = "\n There they are!, to make an offer, press ";
    public static final String HOW_MANY_MONTHS = "and how many months to pay remainder?";
    
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
public static final String WELCOME_PROFILE = "Welcome to Your Profile, ";
    public static final String EDIT_PW  = "Edit your password? :\n";
    public static final String EDIT_FNAME = " first name? :\n";
    public static final String EDIT_LNAME = " ,  edit your last name?  :\n";
    public static final String EDIT_GENDER = " ,  edit your group? :\n";
    public static final String EDIT_EMAIL = " ,  edit your email? :\n";
    public static final String EDIT_PHONE = " ,  edit your phone number? :\n";
    public static final String EDIT_URL = " ,  edit your image URL? :\n";

    // Errors

    public static final String OOPS  = "Oops,  ";
    public static final String OOPS_OPTIONS = "OOPS! options are between 0 and 6 : = ";
    public static final String OOPS_JDBC = "oops, Driver not found :-O. Hey! Check Build Path for the Oracle Java Database Connector Class! Put the ODBC Jar into Build Path";
    
    // titles
    public static final String CARLOT_TITLE = "I-*heart*-electric cars: CarLot view...";
    
    
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

    private final String cmd;
    public String getCmds() {
        return cmd;
    }

    Cmds(String cmd) {
        this.cmd = cmd;
    }

    
 
}
