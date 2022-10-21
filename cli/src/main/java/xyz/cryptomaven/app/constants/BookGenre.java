package xyz.cryptomaven.app.constants;

public enum BookGenre {

    ART("Art"), //0
    BIOGRAPHY("Biography"), //0
    CHILDREN("Children"),  //1
    FICTION("Fiction"),  //2
    HISTORY("History"),  //3
    MYSTERY("Mystery"),  //4
    PHILOSOPHY("Philosophy"),  //5
    RELIGION("Religion"),  //6
    ROMANCE("Romance"),  //7
    SELF_HELP("Self help"),  //8
    TECHNICAL("Technical");  //9

    private BookGenre (String name) {
        this.name = name;
    };
    private String name;
    public String getName() {
        return name;
    }

}
