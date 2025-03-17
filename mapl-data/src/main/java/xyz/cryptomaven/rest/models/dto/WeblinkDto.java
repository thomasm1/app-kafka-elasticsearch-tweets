package xyz.cryptomaven.rest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Builder
@Data
public class WeblinkDto implements Serializable {
    private final long id;
    private final String url;
    private final String host;
    private final String htmlPage;
}
