package xyz.cryptomaven.app.constants;

public enum MovieGenre {

    CLASSICS("Classics"),  //0
    DRAMA("Drama"),  //1
    SCIFI_AND_FANTASY("Sci-Fi & Fantasy"),  //2
    COMEDY("Comedy"),  //3
    CHILDREN_AND_FAMILY("Children & Family"),  //4
    ACTION_AND_ADVENTURE("Action & Adventure"),  //5
    THRILLERS("Thrillers"),  //6
    MUSIC_AND_MUSICALS("Music & Musicals"),  //7
    TELEVISION("Television"),  //8
    HORROR("Horror"),  //9
    SPECIAL_INTEREST("Special Interest"),  //10
    INDEPENDENT("Independent"),  //11
    SPORTS_AND_FITNESS("Sports & Fitness"),  //12
    ANIME_AND_ANIMATION("Anime & Animation"),  //14
    GAY_AND_LESBIAN("Gay & Lesbian"),  //15
    CLASSIC_MOVIE_MUSICALS("Classic Movie Musicals"),  //16
    FAITH_AND_SPIRITUALITY("Faith & Spirituality"),  //17
    FOREIGN_DRAMAS("Foreign Dramas"),  //18
    FOREIGN_ACTION_AND_ADVENTURE("Foreign Action & Adventure"),  //19
    FOREIGN_THRILLERS("Foreign Thrillers"),  //20
    TV_SHOWS("TV Shows"),  //21
    DRAMAS("Dramas"),  //22
    ROMANTIC_MOVIES("Romantic Movies"),  //23
    COMEDIES("Comedies"),  //24
    DOCUMENTARIES("Documentaries"),  //25
    FOREIGN_MOVIES("Foreign Movies");  //26

    private final String movie;

    public String getMovie() {
        return movie;
    }

    private MovieGenre(String movie) {
        this.movie = movie;
    }

}
