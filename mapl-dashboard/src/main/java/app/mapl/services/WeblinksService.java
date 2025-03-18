package app.mapl.services;

import app.mapl.models.Weblink;

import java.util.List;

public interface WeblinksService {
    public Weblink createWeblinks(Weblink bkmk);

    public Weblink getWeblinks(long id);

    public List<Weblink> getAllWeblinks();

    public Weblink updateWeblinks(Weblink change);

    public boolean deleteWeblinks(long id);

}
