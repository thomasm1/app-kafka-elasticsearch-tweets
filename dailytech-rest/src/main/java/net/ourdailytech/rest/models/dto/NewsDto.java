package net.ourdailytech.rest.models.dto;

import lombok.*;

import java.io.Serializable;


/**
 * DTO for {@link net.ourdailytech.rest.models.News}
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@Value
public class NewsDto implements Serializable {
    Long id;
    String title;
    String url;
//    CategoryDto category;
}