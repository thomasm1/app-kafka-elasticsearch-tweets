package app.mapl.util.constants;

public class Datum {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "100";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";


    // FILES
    public static final String LOCAL_SCANNER_TXT = "src/data/scannertext.txt" ;
    public static final String  FILE_IN_COINS = "src/data/files/fileInCoins.txt" ;
    public static final String FILE_IN_WEBLINKS = "src/data/files/fileInWeblinks.txt" ;
    public static final String FILE_OUT_WEBLINKS = "src/data/pages/fileOutWeblinks" ;

    public static final String FILE_IN_BOOKS = "src/data/files/fileInBooks.txt" ;
    public static final String FILE_IN_MOVIES = "src/data/files/fileInMovies.txt" ;
    public static final String FILE_OUT_MOVIES = "src/data/files/fileOutMovies.txt" ;
    public static final String FILE_IN_OFFERS = "src/data/files/fileInOffers.txt" ;
    public static final String FILE_IN_USERS = "src/data/files/fileInUsers.txt" ;
    public static final String FILE_OUT_USERS = "src/data/files/fileOutUsers.txt" ;
    public static final String FILE_OUT_USER = "src/data/files/fileOutUser.txt" ;
    public static final String FILE_OUT_ARRAY = "src/data/files/fileOutArray.txt" ;

    public static final String FILE_IN_GROUPS = "src/data/files/fileInGroups.txt";

    public Datum(String datum) {
        this.datum = datum;
    };


    private Datum String (Datum datum) {
      return  datum ;
    };

    private String datum;

}
