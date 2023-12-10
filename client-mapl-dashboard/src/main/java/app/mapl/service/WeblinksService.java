package app.mapl.service;

import app.mapl.dto.WeblinkDto;

import java.util.List;

public interface WeblinksService {
    public WeblinkDto createWeblinks(WeblinkDto bkmk);

    public WeblinkDto getWeblinks(long id);

    public List<WeblinkDto> getAllWeblinks();

    public WeblinkDto updateWeblinks(WeblinkDto change);

    public boolean deleteWeblinks(long id);

}
