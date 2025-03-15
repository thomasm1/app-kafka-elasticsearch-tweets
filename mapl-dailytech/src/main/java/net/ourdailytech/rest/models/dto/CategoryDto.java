package net.ourdailytech.rest.models.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<NewsDto> news;
//    private List<PostEntityDto> posts;
}

