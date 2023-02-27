package app.mapl.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
