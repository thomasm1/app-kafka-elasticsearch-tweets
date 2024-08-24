package app.mapl.models.dto;

import app.mapl.models.Book;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Book} entity
 */
@Builder
@Data
public class BookDto implements Serializable {
    private final int publicationYear;
    private final String publisher;
    private final String authors;
    private final String genre;
    private final double rating;
    private final String title;
}