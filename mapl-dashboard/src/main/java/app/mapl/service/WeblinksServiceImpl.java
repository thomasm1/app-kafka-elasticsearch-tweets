package app.mapl.service;

import app.mapl.models.Weblink;
import app.mapl.repositories.WeblinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeblinksServiceImpl implements WeblinksService {

    @Autowired
    WeblinksRepository weblinksRepository;
    @Override
    public Weblink createWeblinks(Weblink bkmk) {
        return weblinksRepository.save(bkmk);
    }

    @Override
    public Weblink getWeblinks(long id) {
        try {
            return weblinksRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Weblink> getAllWeblinks() {
        return weblinksRepository.findAll();
    }

    @Override
    public Weblink updateWeblinks(Weblink change) {
        return weblinksRepository.save(change);
    }

    @Override
    public boolean deleteWeblinks(long id) {
        try {
            weblinksRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

