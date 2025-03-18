package app.mapl.services;


import lombok.Getter;


// Like Singleton Managers, This Service is a Controllers return singletons


public class BookmarkServlet {

    @Getter
    private static BookmarkServlet instance = new BookmarkServlet();
    private BookmarkServlet() {}

}
