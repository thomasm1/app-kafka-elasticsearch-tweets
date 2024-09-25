package app.mapl.models;


import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

//Database (MySQL)
//Static List of todos => Database (H2, MySQL)

//JPA
// Bean -> Database Table


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    @Size(min=10, message="Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

}
