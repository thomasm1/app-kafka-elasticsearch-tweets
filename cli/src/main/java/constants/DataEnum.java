package constants;

public enum DataEnum {

    LOCAL_SCANNER_TXT("src/data/scannertext.txt"),
    FILE_IN_CARS("src/data/files/fileInCars.txt"),
    FILE_IN_WEBLINKS("src/data/files/fileInWeblinks.txt"),
    FILE_OUT_WEBLINKS("src/data/files/fileOutWeblinks.txt"),

    FILE_IN_BOOKS("src/data/files/fileInBooks.txt"),
    FILE_IN_MOVIES("src/data/files/fileInMovies.txt"),
    FILE_OUT_MOVIES("src/data/files/fileOutMovies.txt"),

    FILE_IN_USERS("src/data/files/fileInUsers.txt"),
    FILE_OUT_USERS("src/data/files/fileOutUsers.txt"),
    FILE_OUT_USER("src/data/files/fileOutUser.txt"),
    FILE_OUT_ARRAY("src/data/files/fileOutArray.txt");

    private DataEnum (String datumEnum) {
        this.datumEnum = datumEnum;
    };

    private final String datumEnum;
    public String getDatum() {
        return this.datumEnum;
    }

}
