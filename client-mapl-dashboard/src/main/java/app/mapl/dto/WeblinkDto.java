package app.mapl.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class WeblinkDto implements Serializable {
    private final long id;
    private final String url;
    private final String host;
    private final String htmlPage;
}
