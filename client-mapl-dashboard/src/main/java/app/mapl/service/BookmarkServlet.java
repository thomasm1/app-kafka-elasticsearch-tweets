package app.mapl.service;


import lombok.Getter;

import java.util.List;


// Like Singleton Managers, This Service is a Controllers return singletons


public class BookmarkServlet {

    @Getter
    private static BookmarkServlet instance = new BookmarkServlet();
    private BookmarkServlet() {}

}
