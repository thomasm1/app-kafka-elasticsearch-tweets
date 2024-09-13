package app.mapl.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "navigators")
@Document(collection = "navigators")
public class Navigator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Field(name = "dashboard_code")
    private String dashboardCode;
    @Field(name = "organization_code")
    private String organizationCode;
}
