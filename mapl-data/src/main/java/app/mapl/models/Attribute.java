package app.mapl.models;


import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ATTRIBUTE")
public class Attribute  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attrid", nullable = false)
    private int attrid;
    private String valu;
    private String trait_type;
    @ManyToOne
    private Metadata metadata;


}
