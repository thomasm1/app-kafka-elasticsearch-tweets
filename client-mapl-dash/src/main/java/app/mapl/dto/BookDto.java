package app.mapl.dto;

import app.mapl.models.Book;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Book} entity
 */
@Data
public class BookDto implements Serializable {
    private final int publicationYear;
    private final String publisher;
    private final String authors;
    private final String genre;
    private final double rating;
    private final String title;
}