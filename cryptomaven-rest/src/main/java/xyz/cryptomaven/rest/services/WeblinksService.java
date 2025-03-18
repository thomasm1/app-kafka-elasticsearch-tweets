package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.Weblink;

import java.util.List;

public interface WeblinksService {
    public Weblink createWeblinks(Weblink bkmk);

    public Weblink getWeblinks(long id);

    public List<Weblink> getAllWeblinks();

    public Weblink updateWeblinks(Weblink change);

    public boolean deleteWeblinks(long id);

}
