package app.mapl.models;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
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
